package com.example.drovemeds.Repository;


import com.example.drovemeds.Model.CentralAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CentralAdminRepository extends JpaRepository<CentralAdmin,Integer> {

   // CentralAdmin findByUserId(Integer id);
}
