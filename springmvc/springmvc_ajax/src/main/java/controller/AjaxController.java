package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Controller
public class AjaxController {
    @RequestMapping(value = "/testAjax" ,method = RequestMethod.POST)
    public void testAjax(Integer id, HttpServletResponse response) throws IOException {
        System.out.println("id:" + id);
        response.getWriter().write("hello");
    }
    @RequestMapping(value = "/testRequestBody" ,method = RequestMethod.POST)
    public void testAjax(@RequestBody Map<String,Object> user, HttpServletResponse response) throws IOException {
        System.out.println(user);
        response.getWriter().write("requestBody");
    }

    @RequestMapping(value = "/testResponseBody" ,method = RequestMethod.POST)
    @ResponseBody
    public List<User> testResponseBody() throws IOException {
        User user1=new User("邻家大姐哦","dasdad");
        User user2=new User("邻家阿发","qqasd");
        User user3=new User("邻家各个","bxasdad");
        List<User> users = Arrays.asList(user1, user2, user3);
        return users;
    }
}
