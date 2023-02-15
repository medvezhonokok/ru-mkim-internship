package ru.internship.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.internship.form.validator.UserCredentialsRegisterValidator;
import ru.internship.form.UserCredentials;
import ru.internship.service.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class RegisterPage extends AbstractPage {
    private final UserService userService;
    private final UserCredentialsRegisterValidator userCredentialsRegisterValidator;

    public RegisterPage(UserService userService, UserCredentialsRegisterValidator userCredentialsRegisterValidator) {
        this.userService = userService;
        this.userCredentialsRegisterValidator = userCredentialsRegisterValidator;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(userCredentialsRegisterValidator);
    }

    @GetMapping("/register")
    public String get(Model model) {
        model.addAttribute("registerForm", new UserCredentials());
        return "RegisterPage";
    }

    @PostMapping("/register")
    public String post(@Valid @ModelAttribute("registerForm") UserCredentials registerForm,
                       BindingResult bindingResult,
                       HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            return "RegisterPage";
        }

        setUser(httpSession, userService.register(registerForm));
        setMessage(httpSession, "Congrats, you have been registered!");

        return "redirect:/";
    }
}
