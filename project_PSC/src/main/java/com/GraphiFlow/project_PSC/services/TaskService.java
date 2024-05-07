package com.GraphiFlow.project_PSC.services;

import com.GraphiFlow.project_PSC.entities.Task;
import com.GraphiFlow.project_PSC.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    public List<Task> findAll() {
        return repository.findAll();
    }

    public Task findById(Long id) {
        Optional<Task> obj = repository.findById(id);
        return obj.get();
    }

}
