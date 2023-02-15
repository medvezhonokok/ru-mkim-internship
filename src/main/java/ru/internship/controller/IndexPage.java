package ru.internship.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexPage extends AbstractPage {
    @GetMapping({"/", "/index"})
    public String enter() {
        return "IndexPage";
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession) {
        unsetUser(httpSession);
        setMessage(httpSession, "Good bye!");
        return "redirect:";
    }
}
