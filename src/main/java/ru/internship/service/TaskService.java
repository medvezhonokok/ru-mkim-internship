package ru.internship.service;

import org.springframework.stereotype.Service;
import ru.internship.form.TaskCredentials;
import ru.internship.model.Task;
import ru.internship.repository.TaskRepository;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    public List<Task> allTasks() {
        return taskRepository.findAll();
    }
    public List<Task> myTasks(long userId) {
        return taskRepository.getTaskByUserId(userId);
    }

    public Task add(TaskCredentials taskCredentials, long userId) {
        Task task = new Task();
        task.setUserId(userId);
        task.setTitle(taskCredentials.getTitle());
        task.setText(taskCredentials.getText());
        taskRepository.save(task);
        return task;
    }
}
