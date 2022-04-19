package com.example.douglas.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.douglas.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
