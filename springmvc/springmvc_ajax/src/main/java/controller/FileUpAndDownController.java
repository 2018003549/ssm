package controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Controller
public class FileUpAndDownController {
    @RequestMapping("/test/up")
    public String testUp(MultipartFile photo,HttpSession session) throws IOException {
        //获取上传的文件名
        String filename = photo.getOriginalFilename();
        //获取上次文件的后缀名
        String  suffix = filename.substring(filename.lastIndexOf('.'));
        String uuid = UUID.randomUUID().toString();
        filename=uuid+suffix;
        //获取上下文对象
        ServletContext context = session.getServletContext();
        //获取当前工程下photo目录的真实路径
        String realPath = context.getRealPath("photo");
        //创建对应路径的文件对象，判断该路径是否存在
        File file=new File(realPath);
        if(!file.exists()){
            file.mkdirs();//不存在就创建一个目录
        }
        //文件上传路径
        String finalPath=realPath+File.separator+filename;
        //上传文件
        photo.transferTo(new File(finalPath));
        return "success";
    }
    @RequestMapping("/test/down")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws
            IOException {
        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        //获取服务器中文件的真实路径
        String realPath = servletContext.getRealPath("/img/1.jpg");
        System.out.println(servletContext.getRealPath(""));
        //创建输入流
        InputStream is = new FileInputStream(realPath);
        //创建字节数组
        byte[] bytes = new byte[is.available()];
        //将流读到字节数组中
        is.read(bytes);
        //创建HttpHeaders对象设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();
        //设置要下载方式以及下载文件的名字
        headers.add("Content-Disposition", "attachment;filename=1.jpg");
        //设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;
        //创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers,
                statusCode);
        //关闭输入流
        is.close();
        return responseEntity;
    }
}
