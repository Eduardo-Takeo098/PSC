package com.GraphiFlow.project_PSC.resources;

import com.GraphiFlow.project_PSC.entities.Task;
import com.GraphiFlow.project_PSC.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/tasks")
public class TaskResource {

    @Autowired
    private TaskService service;

    @GetMapping("/groupedByCategory")
    public ResponseEntity<Map<String, List<Task>>> findAllGroupedByCategory() {
        Map<String, List<Task>> tasksByCategory = service.findAllGroupedByCategory();
        return ResponseEntity.ok().body(tasksByCategory);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Task> findById(@PathVariable Long id) {
        Task obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}