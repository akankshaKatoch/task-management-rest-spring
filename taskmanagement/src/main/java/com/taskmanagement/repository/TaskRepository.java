package com.taskmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taskmanagement.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

    
} 