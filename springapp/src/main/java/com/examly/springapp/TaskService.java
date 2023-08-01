package com.examly.springapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public void deleteTaskById(Long id) {
        taskRepository.deleteById(id);
    }

    public List<Task> getTasksByHolderName(String taskHolderName) {
        return taskRepository.findAllByTaskHolderName(taskHolderName);
    }

    public Task changeTaskStatus(Long id, String newStatus) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setTaskStatus(newStatus);
            return taskRepository.save(task);
        }
        return null;
    }
}