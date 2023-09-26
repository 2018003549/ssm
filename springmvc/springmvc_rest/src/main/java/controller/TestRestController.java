package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pojo.User;

@Controller
public class TestRestController {
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getAllUser(){
        System.out.println("查询到所有用户");
        return "success";
    }
    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public String getAllUser(@PathVariable("id") Integer id){
        System.out.println("查询到id为"+ id+"的用户");
        return "success";
    }
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String insert(User user){
        System.out.println(user);
        return "success";
    }
    @RequestMapping(value = "/user/{id}",method = RequestMethod.PUT)
    public String update(@PathVariable("id")Integer id){
        System.out.println("修改id为"+id+"的用户信息");
        return "success";
    }
    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable("id")Integer id){
        System.out.println("修改id为"+id+"的用户信息");
        return "success";
    }
}
