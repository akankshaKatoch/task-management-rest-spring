package com.taskmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.taskmanagement.model.Task;
import com.taskmanagement.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service 
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id){
        return taskRepository.findById(id).orElse(null);
    }
    
    public Task createTask(Task task){
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task taskDetails){
        Task task = taskRepository.findById(id).orElse(null);
        if (task != null){
            task.setTitle(taskDetails.getTitle());
            task.setDescription(taskDetails.getDescription());
            task.setCompleted(taskDetails.isCompleted());
            return taskRepository.save(task);
        }
        return null;
    }

    public void deleteTask(long id){
        taskRepository.deleteById(id);
    }
    
}
