package com.example.drovemeds.Service;

import com.example.drovemeds.Exception.ApiException;
import com.example.drovemeds.Model.*;
import com.example.drovemeds.Repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor

public class RequestService {

    private final RequestRepository requestRepository;
    private  final MedicineRepository medicineRepository;
    private  final PatientRepository patientRepository;
   // private  final RequestDetailsService  requestDetailsService;
    private  final HospitalRepository hospitalRepository;
    private  final  DeliveryScheduleService deliveryScheduleService;

    private  final UserRepository userRepository;




    public List<Request> getRequestByUser(User user){

        return requestRepository.findAllByUser(user);
    }



    public List<Request> getRequest(){

        return requestRepository.findAll();
    }


    public void addRequest(Request request, Integer patientId,User userobj){

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        request.setSubmittingDate(dtf.format(now));

        Format f = new SimpleDateFormat("EEEE");
        String str = f.format(new Date());
        request.setDay(str);


        Patient objPatient = patientRepository.findPatientByPatientId(patientId);
      //  Hospital hospital  =  hospitalRepository.findHospitalById(objPatient.getPatientId());

        User user = userRepository.findUsersByUserId(userobj.getUserId());

        if (objPatient==null /*|| hospital==null*/ || user==null)
        {
            throw new ApiException(" Patient  or hospital or user not found");

        }

        request.setUser(user);
        request.setStatus("waiting");
        request.setPatient(objPatient); // Assign Patient To Request 1M

        request.setHospital(objPatient.getHospital()); // Assign Hospital To Request  1M


        requestRepository.save(request);

      /*  if (request.getEmergencyLevel().equals("rush"))
        {
            requestRepository.save(request);
            ApproveRequest(request.getRequestId());

        }
*/



    }


    public void updateRequest(Integer id, Request request){
        Request old = requestRepository.findRequestByRequestId(id);
        if (old==null) {
                 throw new ApiException(" Request not found");

        }

        old.setDeliveryTime(request.getDeliveryTime());
        old.setEmergencyLevel(request.getEmergencyLevel());


        requestRepository.save(old);

    }

    public void deleteRequest(Integer id){

        Request old = requestRepository.findRequestByRequestId(id);
        if (old==null) {
            throw new ApiException(" Request not found");
        }
        requestRepository.deleteById(id);

    }




    public void totalPrice(Integer requestId){

        Request request = requestRepository.findRequestByRequestId(requestId);
        double total=0.0;

        if (request==null) {
            throw new ApiException(" Request not found");

        }

        for(int i=0; i<request.getDetails().size() /*request.getMedicines().size()*/; i++ )
       {


         //  Medicine itemPrice=  medicineRepository.findMedicineById(request.getMedicines().get(i).getId());
           Medicine itemPrice=  medicineRepository.findMedicineById(request.getDetails().get(i).getId());
           total= total + (itemPrice.getPrice()*request.getDetails().get(i).getQuantity());

         }

        request.setTotalPrice(total);
        requestRepository.save(request);



    }




  public void ApproveRequest(Integer id)
    {

        Request request = requestRepository.findRequestByRequestId(id);
        Patient patient= patientRepository.findPatientByPatientId(request.getPatient().getPatientId());

        if (request==null|| patient==null) {
            throw new ApiException("Not found");
        }

    for(int i=0; i< request.getDetails().size(); i++ )
    {
        Medicine medicine= medicineRepository.findMedicineById(request.getDetails().get(i).getId());

        if (medicine==null ) {
            throw new ApiException(" Medicine  not found");
        }

        if (medicine.getQuantity() >= request.getDetails().get(i).getQuantity()) {
             if ((medicine.getPrice() <= patient.getBalance()) && (request.getStatus().equals("waiting"))) {

                 request.setStatus("approved");
                 totalPrice(request.getRequestId()); // call another  function

                 medicine.setQuantity(medicine.getQuantity() - request.getDetails().get(i).getQuantity());
                 patient.setBalance(patient.getBalance() - request.getTotalPrice());

                 requestRepository.save(request);
                 medicineRepository.save(medicine);
                 patientRepository.save(patient);
                 deliveryScheduleService.addDeliverySchedule(request.getRequestId());


             }
             else request.setStatus("rejected");
             requestRepository.save(request);

         } else {
             request.setStatus("lack");
             requestRepository.save(request);
         }
     }


    }


    public void deliveredRequest(Integer id)
    {

        Request request = requestRepository.findRequestByRequestId(id);

        if (request==null) {
            throw new ApiException("Not found");
        }
        request.setStatus("delivered");

        requestRepository.save(request);

    }




    public List<Request> getRequestByLevel(String level)
    {

     return requestRepository.findAllByEmergencyLevel(level);

    }

    public List<Request> getRequestByStatus(String status)
    {
    return requestRepository.findAllByStatus(status);
    }






    }
