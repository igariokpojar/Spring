package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

//    @RequestMapping("/home")
//    // this method need to return the view
//    public String home() { // which en point? www.amazon.com/register
//        return "home.html";
//    }

    @RequestMapping("/home")// @RequestMapping is used to create our end points
    public String getHomePage(){
        return "home.html"; // Controllers job is to return view
    }

    @RequestMapping("/alex")
    public String getHomePage2(){
        return "home.html";
    }

    @RequestMapping // nothing and /
    public String getHomePage3(){
        return "home.html";
    }

    @RequestMapping ({"/apple","/orange"})
    public String getHomePage4(){
        return "home.html";
    }


}
