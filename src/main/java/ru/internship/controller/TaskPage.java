package ru.internship.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.internship.form.TaskCredentials;
import ru.internship.model.Task;
import ru.internship.service.TaskService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class TaskPage extends AbstractPage {
    final private TaskService taskService;

    public TaskPage(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks_all")
    public String allTasks(Model model) {
        model.addAttribute("tasks", taskService.allTasks());
        return "TasksPage";
    }

    @GetMapping("/add_task")
    public String get(Model model) {
        model.addAttribute("addForm", new TaskCredentials());
        return "TaskAddPage";
    }

    @PostMapping("/add_task")
    public String post(@Valid @ModelAttribute("addForm") TaskCredentials addForm,
                       BindingResult bindingResult,
                       HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            return "TaskAddPage";
        }

        long userId = (long) httpSession.getAttribute("userId");

        setTask(httpSession, taskService.add(addForm, userId));
        setMessage(httpSession, "Congrats, you have added task!");

        return "redirect:/";
    }

    @GetMapping("/my_tasks")
    public String myTasks(Model model, HttpSession httpSession) {
        if (httpSession.getAttribute("userId") != null) {

            long id = (long) httpSession.getAttribute("userId");

            List<Task> myTasks = taskService.myTasks(id);
            if (myTasks.size() > 0) {
                model.addAttribute("myTasks", myTasks);
            }
            return "MyTasksPage";
        } else {
            setMessage(httpSession, "You have to authorize");
            return "redirect:";
        }
    }
}
