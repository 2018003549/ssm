package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ExceptionController {
 @RequestMapping("/test/hello")
    public String testException(){
     System.out.println(1/0);
     return "success";
 }

}
