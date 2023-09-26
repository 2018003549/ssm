package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
    @RequestMapping("view/forward")
    public String testForward(){
        return "forward:/test/mav";
    }
    @RequestMapping("view/redirect")
    public String testRedirect(){
        return "redirect:/test/mav";
    }
}
