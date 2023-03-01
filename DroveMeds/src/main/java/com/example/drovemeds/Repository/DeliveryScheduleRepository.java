

package com.example.drovemeds.Repository;


import com.example.drovemeds.Model.DeliverySchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryScheduleRepository extends JpaRepository <DeliverySchedule,Integer> {

    DeliverySchedule findDeliveryScheduleById(Integer id);

}