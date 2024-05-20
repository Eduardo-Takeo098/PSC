package com.GraphiFlow.project_PSC.repositories;

import com.GraphiFlow.project_PSC.entities.UserAdm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAdmRepository extends JpaRepository<UserAdm, Long> {
}

