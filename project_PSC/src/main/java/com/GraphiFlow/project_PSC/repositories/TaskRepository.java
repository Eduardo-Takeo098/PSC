package com.GraphiFlow.project_PSC.repositories;

import com.GraphiFlow.project_PSC.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
