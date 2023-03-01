package com.example.drovemeds.Repository;

import com.example.drovemeds.Model.Request;
import com.example.drovemeds.Model.requestDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface RequestDetailsRepository extends JpaRepository<requestDetails,Integer>
{


    requestDetails findAllById(Integer id);

    






}
