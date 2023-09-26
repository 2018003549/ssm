package controller;

import Pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
public class ParamController {
    @RequestMapping("/testParam")
    public String testParam(HttpServletRequest request) throws UnsupportedEncodingException {
        String username = request.getParameter("username");
        System.out.println("username:" + username);
        return "success";
    }

    @RequestMapping("/Param")
    public String testParam(@RequestParam(defaultValue = "张三") String username, @RequestHeader("referer") String refer) {
        System.out.println("username:" + username);
        System.out.println(refer);
        return "success";
    }

    @RequestMapping("/pojoParam")
    public String getByPojo(User user) {
        System.out.println(user.getUserName() + " " + user.getPassWord());
        return "success";
    }
}

