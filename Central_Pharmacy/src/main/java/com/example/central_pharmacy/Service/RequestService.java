package com.example.central_pharmacy.Service;

import com.example.central_pharmacy.Exception.ApiException;
import com.example.central_pharmacy.Model.Link;
import com.example.central_pharmacy.Model.Medicine;
import com.example.central_pharmacy.Model.Patient;
import com.example.central_pharmacy.Model.Request;
import com.example.central_pharmacy.Repository.LinkRepository;
import com.example.central_pharmacy.Repository.MedicineRepository;
import com.example.central_pharmacy.Repository.RequestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class RequestService {

    private final RequestRepository requestRepository;
    private  final MedicineRepository medicineRepository;

    private final LinkRepository linkRepository;
    private  final PatientService patientService;


    public List<Request> getRequest(){
        return requestRepository.findAll();
    }

    public void addRequest(Request request){

        request.setStatus("waiting");
        requestRepository.save(request);
    }


    public void updateRequest(Integer id, Request request){
        Request old = requestRepository.findRequestById(id);
        if (old==null) {
                 throw new ApiException(" Request not found");

        }
        old.setStatus(request.getStatus());
        old.setQuantity(request.getQuantity());
        old.setPatientId(request.getPatientId());
        old.setHospitalId(request.getHospitalId());
        old.setMedicineId(request.getMedicineId());
        old.setTotalPrice(request.getTotalPrice());

        requestRepository.save(old);

    }

    public void deleteRequest(Integer id){

        Request old = requestRepository.findRequestById(id);
        if (old!=null) {
            requestRepository.deleteById(id);
        }
        throw new ApiException(" Request not found");


    }

    public void totalPrice( Integer requestId){

        Medicine itemPrice;
        Request updated = requestRepository.findRequestById(requestId);
        double total=0.0;

        if (updated==null) {
            throw new ApiException(" Request not found");

        }


      //  List<Link> links = linkRepository.findAllByRequestId(updated.getId());
        Link link = linkRepository.findByRequestId(updated.getId());

    //    for(int i=0; links.; i++ )
    //    {


            itemPrice=  medicineRepository.findMedicineById(link.getMedicineId());

            total= total+ itemPrice.getPrice();


       //  }

        updated.setTotalPrice(total);

    }


    public void checkStatus(Integer id)
    {
        Request request = requestRepository.findRequestById(id);
        if (request==null) {
            throw new ApiException(" Request not found");
        }
        int patientId= request.getPatientId();
        int MedicineId= request.getMedicineId();

        Patient patient= patientService.patientRepository.findPatientByPatientId(patientId);
        Medicine medicine= medicineRepository.findMedicineById(MedicineId);

        if(medicine.getQuantity()>=request.getQuantity())
        {
            if (medicine.getPrice() >= patient.getBalance())
                request.setStatus("approved");

        }

        throw new ApiException("No balance or quantity !");


    }





    }
