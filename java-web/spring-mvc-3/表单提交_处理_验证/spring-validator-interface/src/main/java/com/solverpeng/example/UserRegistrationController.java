package com.solverpeng.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/register")
public class UserRegistrationController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String handleGetRequest (Model model) {
        model.addAttribute("user", new User());
        return "user-registration";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String handlePostRequest (@ModelAttribute("user") User user,
                                     BindingResult bindingResult, Model model) {
        new UserValidator().validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "user-registration";
        }

        userService.saveUser(user);
        return "registration-done";
    }
}
