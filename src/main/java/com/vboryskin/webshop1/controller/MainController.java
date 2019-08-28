package com.vboryskin.webshop1.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping({"/", "/index", "/logout"})
    public String index(){
        return "index";
    }

}
