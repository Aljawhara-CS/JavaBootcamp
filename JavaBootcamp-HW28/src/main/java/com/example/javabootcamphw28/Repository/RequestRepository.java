package com.example.javabootcamphw28.Repository;

import com.example.javabootcamphw28.Model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RequestRepository extends JpaRepository<Request,Integer> {

    Request findOrderById(Integer id);
}
