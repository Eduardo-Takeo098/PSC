package com.GraphiFlow.project_PSC.services;

import com.GraphiFlow.project_PSC.entities.Task;
import com.GraphiFlow.project_PSC.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    public Map<String, List<Task>> findAllGroupedByCategory() {
        List<Task> tasks = repository.findAll();
        return tasks.stream().collect(Collectors.groupingBy(task -> task.getCategories().iterator().next().getName()));
    }

    public Task findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Task save(Task task) {
        return repository.save(task);
    }
}