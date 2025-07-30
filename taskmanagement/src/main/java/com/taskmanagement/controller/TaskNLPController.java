package com.taskmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanagement.model.Task;
import com.taskmanagement.service.OpenAIService;

@RestController
@RequestMapping("/api/tasks")
public class TaskNLPController {
    @Autowired
    private OpenAIService openAIService;

    @PostMapping("/nlp")
    public ResponseEntity<Task> createTaskFromNaturalLanguag(@RequestBody String inputText){
        Task task = openAIService.parseTaskFromText(inputText);
        return ResponseEntity.ok(task);
    }
    
}
