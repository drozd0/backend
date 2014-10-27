package ru.qlogistic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.qlogistic.entity.User;
import ru.qlogistic.manager.UserManager;
import ru.qlogistic.service.UserService;

@Controller
public class MainController {
    @Autowired
    private UserManager userManager;

    @Autowired
    private UserService userService;
    private String errorRegistration;
    private String errorEdit;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String root() {
        return "redirect:signin";
    }

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String signin() {
        return "signin";
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(Model model) {
        model.addAttribute("currentUser", userService.getCurrentUser());
        return "main";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String user(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("message", errorRegistration);
        return "registration";
    }
}
