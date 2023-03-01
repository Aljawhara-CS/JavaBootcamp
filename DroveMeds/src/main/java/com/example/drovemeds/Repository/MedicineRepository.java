package com.example.drovemeds.Repository;

import com.example.drovemeds.Model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface MedicineRepository extends JpaRepository<Medicine,Integer> {


    Medicine findMedicineById(Integer id);


}
