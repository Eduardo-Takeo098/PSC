package com.GraphiFlow.project_PSC.repositories;

import com.GraphiFlow.project_PSC.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}