package com.taskmanagement.controller;

import com.taskmanagement.model.Task;
import com.taskmanagement.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    
    @Autowired
    private TaskService taskService;

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id){
        return taskService.getTaskById(id);
    }

    @PostMapping
    public Task createTask(@RequestBody Task task){
        return taskService.createTask(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task){
        return taskService.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }
}
