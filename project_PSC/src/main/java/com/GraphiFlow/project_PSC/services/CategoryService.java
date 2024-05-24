package com.GraphiFlow.project_PSC.services;

import com.GraphiFlow.project_PSC.entities.Category;
import com.GraphiFlow.project_PSC.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
    }
}
