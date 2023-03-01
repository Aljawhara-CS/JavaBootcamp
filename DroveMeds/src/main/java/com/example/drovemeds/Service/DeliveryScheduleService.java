
package com.example.drovemeds.Service;


import com.example.drovemeds.Exception.ApiException;
import com.example.drovemeds.Model.DeliverySchedule;
import com.example.drovemeds.Model.Request;
import com.example.drovemeds.Repository.DeliveryScheduleRepository;
import com.example.drovemeds.Repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor

public class DeliveryScheduleService {

    private final DeliveryScheduleRepository deliveryScheduleRepository;
    private final RequestRepository requestRepository;

    public List<DeliverySchedule> getSchedule() {
        return deliveryScheduleRepository.findAll();
    }

    public void addDeliverySchedule(Integer requestId) {


        Request request = requestRepository.findRequestByRequestId(requestId);

        if (request == null) {
            throw new ApiException(" Request not found");
        }

        if (((request.getEmergencyLevel().equals("normal")) || (request.getEmergencyLevel().equals("rush")))
                && (request.getStatus().equals("approved"))) {


            DeliverySchedule deliverySchedule = new DeliverySchedule();


            if (request.getDeliveryTime().equals("Morning")) {
                deliverySchedule.setTimeDelivery("From 6:00 AM - 11:59 AM");
            } else if (request.getDeliveryTime().equals("Evening")) {
                deliverySchedule.setTimeDelivery("From 12:00 PM - 5:59 PM");
            } else if (request.getDeliveryTime().equals("AfterEvening")) {
                deliverySchedule.setTimeDelivery("From 6:00 PM - 10:00 PM");

            }

            request.setStatus("scheduled");
            deliverySchedule.setDateDelivery(request.getSubmittingDate());
            deliverySchedule.setDay(request.getDay());
            deliverySchedule.setRequest(request);

            requestRepository.save(request);
            deliveryScheduleRepository.save(deliverySchedule);

        } else
            throw new ApiException(" This request not approved yet! OR EmergencyLevel is not Normal to ask user to Schedule the request");

    }


    public void updateDeliverySchedule(Integer id, DeliverySchedule delivery){
        DeliverySchedule schedule = deliveryScheduleRepository.findDeliveryScheduleById(id);
        if (schedule == null) {
            throw new ApiException(" DeliverySchedule  not found");
        }

     //   schedule.setRequestId(delivery.getRequestId());
        schedule.setDay(delivery.getDay());
        schedule.setDateDelivery(delivery.getDateDelivery());

        deliveryScheduleRepository.save(schedule);
    }

    public void deleteDeliverySchedule(Integer id)
    {
        DeliverySchedule schedule = deliveryScheduleRepository.findDeliveryScheduleById(id);

        if (schedule != null) {
            deliveryScheduleRepository.deleteById(id);

        }
        else throw new ApiException(" DeliverySchedule is not found");


    }

    // how many   scheduled request per day
    // get appproved reqest only




}
