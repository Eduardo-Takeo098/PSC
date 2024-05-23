package com.GraphiFlow.project_PSC.resources;

import com.GraphiFlow.project_PSC.entities.Project;
import com.GraphiFlow.project_PSC.entities.Task;
import com.GraphiFlow.project_PSC.services.ProjectService;
import com.GraphiFlow.project_PSC.services.TaskService;
import com.GraphiFlow.project_PSC.entities.enums.ProjectStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping(value = "/projects")
public class ProjectResource {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Project>> findAll() {
        List<Project> list = projectService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Project> findById(@PathVariable Long id) {
        Project obj = projectService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Project> createProjectWithTask(
            @RequestParam String taskName,
            @RequestParam String taskDescription,
            @RequestParam(required = false) String taskUrlImg) {

                Project project = new Project();
                project.setMoment(Instant.now());
                project.setProjectStatus(ProjectStatus.WAITING_DELIVERY);
                project = projectService.save(project);

                Task task = new Task();
                task.setName(taskName);
                task.setDescription(taskDescription);
                task.setImgUrl(taskUrlImg);
                taskService.save(task);

                return ResponseEntity.ok().body(project);
            }
}
