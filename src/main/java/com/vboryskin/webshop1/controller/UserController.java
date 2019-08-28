package com.vboryskin.webshop1.controller;

import com.vboryskin.webshop1.dto.UserDTO;
import com.vboryskin.webshop1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(@RequestParam(name = "error", defaultValue = "false") String hasError,
                        Model model){
        if(Boolean.valueOf(hasError)){
            model.addAttribute("error", "Invalid username or password");
        }
        return "login";
    }
    @GetMapping("/registration")
    public String register(Model model){
        model.addAttribute("user", new UserDTO());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute(name = "user") @Valid UserDTO user, BindingResult result,
                           WebRequest webRequest, Errors errors){
        if(result.hasErrors()){
            return "/register";
        }
        userService.registerNewUser(user);
        return "redirect:/index";
    }

    @GetMapping("/profile")
    public String profile(Principal principal, Model model){
        model.addAttribute("username", principal.getName());
        System.out.println(userService.findOne(principal.getName()));
        return "profile";
    }
}
