package com.example.drovemeds.Repository;

import com.example.drovemeds.Model.HospitalAdmin;
import com.example.drovemeds.Model.Request;
import com.example.drovemeds.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface RequestRepository extends JpaRepository<Request,Integer>
{

    Request findRequestByRequestId(Integer id);

    List <Request> findAllByUser(User user);

    List<Request> findAllByEmergencyLevel (String level);
    List<Request> findAllByStatus(String status);

    @Query("Select u from Request u where u.status='delivered'")
    List<Request> findRequestByStatusIsDelivered();





}
