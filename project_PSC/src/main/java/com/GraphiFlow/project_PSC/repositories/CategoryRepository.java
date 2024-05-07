package com.GraphiFlow.project_PSC.repositories;

import com.GraphiFlow.project_PSC.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
