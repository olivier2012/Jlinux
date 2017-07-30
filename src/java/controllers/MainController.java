package controllers;


import javax.servlet.http.*;

import org.springframework.web.servlet.*;
import org.springframework.web.servlet.mvc.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
    
    @RequestMapping(value = {"login", "/login.jsp"})
    public String login(){
        return "login";
    }
    
    @RequestMapping(value = {"home", "/home.jsp"})
    public String home(){
        return "home";
    }
    
    @RequestMapping(value = {"/index", "index.jsp"})
    public String indexPage(){
        return "index";
    }

}
