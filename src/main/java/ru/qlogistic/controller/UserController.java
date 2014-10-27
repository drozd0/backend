package ru.qlogistic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.qlogistic.entity.User;
import ru.qlogistic.manager.UserManager;
import ru.qlogistic.service.UserService;

@Controller
//@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserManager userManager;

    @Autowired
    private UserService userService;
    private String errorRegistration;
    private String errorEdit;

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute(value = "user") User _user){
        try{
            User user = userService.loadUserByUsername(_user.getEmail());
            if (user != null){
                errorRegistration = "login is buzy";
                return "redirect:/registration";
            }
            errorRegistration = "";
            userManager.createUser(_user);
        }catch (UsernameNotFoundException ex){

        }
        return "redirect:/main";
    }

    @RequestMapping(value = "/user/edit", method = RequestMethod.GET)
    public String editUser(Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        model.addAttribute("message", errorEdit);
        return "user";
    }
}
