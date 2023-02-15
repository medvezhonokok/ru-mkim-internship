package ru.internship.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import ru.internship.model.Task;
import ru.internship.model.User;
import ru.internship.service.UserService;

import javax.servlet.http.HttpSession;

public class AbstractPage {
    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public User getUser(HttpSession httpSession) {
        return userService.findById((Long) httpSession.getAttribute("userId"));
    }

    @ModelAttribute("message")
    public String getMessage(HttpSession httpSession) {
        String message = (String) httpSession.getAttribute("message");
        httpSession.removeAttribute("message");
        return message;
    }

    public void setUser(HttpSession httpSession, User user) {
        if (user != null) {
            httpSession.setAttribute("userId", user.getId());
        } else {
            unsetUser(httpSession);
        }
    }

    public void setTask(HttpSession httpSession, Task task) {
        if (task != null) {
            httpSession.setAttribute("taskId", task.getId());
        } else {
            unsetTask(httpSession);
        }
    }

    private void unsetTask(HttpSession httpSession) {
        httpSession.removeAttribute("taskId");
    }

    public void unsetUser(HttpSession httpSession) {
        httpSession.removeAttribute("userId");
    }

    public void setMessage(HttpSession httpSession, String messgate) {
        if (messgate != null) {
            httpSession.setAttribute("message", messgate);
        } else {
            unsetMessage(httpSession);
        }
    }

    public void unsetMessage(HttpSession httpSession) {
        httpSession.removeAttribute("message");
    }
}
