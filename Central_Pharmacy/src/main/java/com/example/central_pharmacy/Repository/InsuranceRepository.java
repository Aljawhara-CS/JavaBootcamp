package com.example.central_pharmacy.Repository;

import com.example.central_pharmacy.Model.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface InsuranceRepository  extends JpaRepository<Insurance,Integer> {


    Insurance findByInsuranceId(Integer id);


}
