package com.example.drovemeds.Repository;


import com.example.drovemeds.Model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository  extends JpaRepository<Hospital,Integer> {
    Hospital findHospitalById(Integer id);
    Hospital findHospitalByName(String name);
}


