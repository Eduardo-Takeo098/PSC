package com.GraphiFlow.project_PSC.services;

import com.GraphiFlow.project_PSC.entities.Project;
import com.GraphiFlow.project_PSC.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository repository;

    public List<Project> findAll() {
        return repository.findAll();
    }

    public Project findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Project save(Project project) {
        return repository.save(project);
    }
}
