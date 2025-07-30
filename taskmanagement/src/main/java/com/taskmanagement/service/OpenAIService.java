package com.taskmanagement.service;

import java.time.LocalDate;
import java.util.List;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.taskmanagement.model.Task;

@Service
public class OpenAIService {
    private final String OPENAI_API_KEY = "your-api-key";
    private final String OPENAI_URL = "https://api.openai.com/v1/chat/completions";

    public Task parseTaskFromText(String input) {

        RestTemplate restTemplate = new RestTemplate();

        String prompt = "Extract a task from this: \"" + input + "\". Return title, due date (if any), priority.";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + OPENAI_API_KEY);
        headers.setContentType(MediaType.APPLICATION_JSON);

        JSONObject message = new JSONObject().put("model", "gpt-4").put("messages", List.of(
                new JSONObject().put("role", "system").put("content", "You are a helpful assistant."),
                new JSONObject().put("role", "user").put("content", prompt)));
        
        HttpEntity<String> entity = new HttpEntity<>(message.toString(), headers);
        HttpEntity<String> response = restTemplate.postForEntity(OPENAI_URL, entity, String.class);
        //String content = new JSONObject(response.getBody()).getJSONArray("choices").getJSONObject("message").getString("content");

        String content = new JSONObject(response.getBody())
                .getJSONArray("choices")
                .getJSONObject(0)
                .getJSONObject("message")
                .getString("content");


        Task task = new Task();
        task.setTitle(extractTitle(content));
        task.setPriority(extractPriority(content));
        task.setDueDate(extractDueDate(content));
        return task;
    }

    private String extractTitle(String response) {
        // Add logic to parse response
        return "Sample Task";
    }

    private String extractPriority(String response) {
        return "High";
    }

    private LocalDate extractDueDate(String response) {
        return LocalDate.now().plusDays(2);
    }

}
