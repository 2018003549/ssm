package controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Exception {
    @ExceptionHandler({ArithmeticException.class,NullPointerException.class})
    public String solve(Throwable ex, Model model){
        model.addAttribute("ex",ex);
        return "error";
    }
}
