package ru.internship.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.internship.service.UserService;

import javax.servlet.http.HttpSession;

@Controller
public class UserPage extends AbstractPage {

    private final UserService userService;

    public UserPage(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users_{id}")
    public String getUserById(@PathVariable String id, Model model) {
        model.addAttribute("isUser", userService.findById(Long.parseLong(id)));
        return "UserPage";
    }
}
