package com.GraphiFlow.project_PSC.resources;

import com.GraphiFlow.project_PSC.entities.Task;
import com.GraphiFlow.project_PSC.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Map<String, String> taskData) {
        String taskName = taskData.get("taskName");
        String taskDescription = taskData.get("taskDescription");
        String taskUrlImg = taskData.get("taskUrlImg");
        Long categoryId = Long.parseLong(taskData.get("categoryId"));

        Task newTask = service.createTask(taskName, taskDescription, taskUrlImg, categoryId);
        return ResponseEntity.ok().body(newTask);
    }
}
