package com.examly.springapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/saveTask")
    public Task saveTask(@RequestBody Task task) {
        return taskService.saveTask(task);
    }

    @GetMapping("/alltasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/getTask")
    public Optional<Task> getTaskById(@RequestParam Long taskId) {
        return taskService.getTaskById(taskId);
    }

    @GetMapping("/getTaskByHolderName")
    public List<Task> getTasksByHolderName(@RequestParam String taskHolderName) {
        return taskService.getTasksByHolderName(taskHolderName);
    }

    @GetMapping("/changeStatus")
    public Task changeTaskStatus(@RequestParam Long id, @RequestParam String taskStatus) {
        return taskService.changeTaskStatus(id, taskStatus);
    }

    @GetMapping("/deleteTask")
    public void deleteTask(@RequestParam Long id) {
        taskService.deleteTaskById(id);
    }
}
