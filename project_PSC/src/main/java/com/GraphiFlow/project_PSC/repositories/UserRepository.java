package com.GraphiFlow.project_PSC.repositories;

import com.GraphiFlow.project_PSC.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
