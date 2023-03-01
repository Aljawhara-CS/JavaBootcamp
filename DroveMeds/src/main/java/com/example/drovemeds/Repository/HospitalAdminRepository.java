package com.example.drovemeds.Repository;

import com.example.drovemeds.Model.HospitalAdmin;
import com.example.drovemeds.Model.requestDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface HospitalAdminRepository extends JpaRepository<HospitalAdmin,Integer>
{


   HospitalAdmin findByUserId(Integer id);









}
