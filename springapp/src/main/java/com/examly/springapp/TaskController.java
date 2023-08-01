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
    public ResponseEntity<Task> getTaskById(@RequestParam Long taskId) {
        Optional<Task> task = taskService.getTaskById(taskId);
        if (task.isPresent()) {
            return ResponseEntity.ok(task.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getTaskByHolderName")
    public List<Task> getTasksByHolderName(@RequestParam String taskHolderName) {
        return taskService.getTasksByHolderName(taskHolderName);
    }

    @GetMapping("/changeStatus")
    public ResponseEntity<Task> changeTaskStatus(@RequestParam Long id, @RequestParam String taskStatus) {
        Task task = taskService.changeTaskStatus(id, taskStatus);
        if (task != null) {
            return ResponseEntity.ok(task);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/deleteTask")
    public ResponseEntity<Void> deleteTask(@RequestParam Long id) {
        Optional<Task> task = taskService.getTaskById(id);
        if (task.isPresent()) {
            taskService.deleteTaskById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

