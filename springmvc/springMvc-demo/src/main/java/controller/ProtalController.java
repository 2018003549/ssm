package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class ProtalController {
    @RequestMapping(value = {"abc", "hello"}, method = RequestMethod.POST)
    public String protal() {
        return "success";
    }

    @RequestMapping("/")
    public String protalIndex() {
        return "index";
    }

    @RequestMapping("test/rest/{id}/{userName}")
    public String testRest(@PathVariable("id") Integer userId,@PathVariable("userName")String userName) {
        System.out.println("id为"+userId+"的用户是"+userName);
        return "success";
    }

    @RequestMapping("test/mav")
    public ModelAndView testMav(){
        //获取modelAndview对象
        ModelAndView mav=new ModelAndView();
        mav.addObject("testMAV","恭喜你入门了ModelAndView");//往请求域中存储数据
        mav.setViewName("success");//指定跳转的逻辑视图
        return mav;
    }
    @RequestMapping("test/model")
    public String testModel(Model model){
        model.addAttribute("testMAV","恭喜你入门了Model");
        return "success";
    }
    @RequestMapping("test/modelMap")
    public String testModel(ModelMap model){
        model.addAttribute("testMAV","恭喜你入门了ModelMap");
        return "success";
    }
    @RequestMapping("test/map")
    public String testModel(Map<String,Object> map){
        map.put("testMAV","恭喜你入门了Map");
        return "success";
    }
    @RequestMapping("/test/session")
    public String testSession(HttpSession session){
        session.setAttribute("testMAV","session域");
        return "success";
    }
    @RequestMapping("/test/application")
    public String testApplication(HttpSession session){
        ServletContext context = session.getServletContext();
        context.setAttribute("testMAV","application域");
        return "success";
    }
}

