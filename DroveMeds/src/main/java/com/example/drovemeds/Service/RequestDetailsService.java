package com.example.drovemeds.Service;


import com.example.drovemeds.DTO.DetailDTO;
import com.example.drovemeds.Exception.ApiException;
import com.example.drovemeds.Model.Medicine;
import com.example.drovemeds.Model.Request;
import com.example.drovemeds.Model.requestDetails;
import com.example.drovemeds.Repository.MedicineRepository;
import com.example.drovemeds.Repository.RequestDetailsRepository;
import com.example.drovemeds.Repository.RequestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RequestDetailsService {


    private final RequestDetailsRepository detailsRepository;
    private final RequestRepository requestRepository;
    private  final MedicineRepository medicineRepository;

    private final RequestService requestService;

    public List<requestDetails> getRequestDetailsService()
    {
        return detailsRepository.findAll();

    }


/*    public void AddRequestDetailsService(Request request, Integer patientId)
    {


        Request request =requestRepository.findRequestByRequestId(objreq.getRequestId());
        Medicine medicine= medicineRepository.findMedicineById(objmed.getId());


        if ( request==null || medicine==null )
        {
            throw new ApiException("Not found");
        }

        requestDetails details = new requestDetails(null,quantity,request,medicine);
        detailsRepository.save(details);

    }*/

    public void AddMedicineItemToRequest(DetailDTO obj, Integer requestId)
    {


            Medicine medicine = medicineRepository.findMedicineById(obj.getMedicine_id());
            Request request= requestRepository.findRequestByRequestId(requestId);


            if (medicine == null || request==null) {
                throw new ApiException("Not found");
            }
               requestDetails details= new requestDetails(null, obj.getQuantity(),request,medicine);
               details.setMedicine(medicine);

            detailsRepository.save(details);
        if (request.getEmergencyLevel().equals("rush"))
        {
            requestService.ApproveRequest(request.getRequestId());

        }


    }

    public void DeleteMedicineItemInRequest(Integer detailId)
    {

        requestDetails details = detailsRepository.findAllById(detailId);


        if (details == null) {
            throw new ApiException("Not found");
        }

        detailsRepository.delete(details);

    }

    public void editMedicineItemToRequest(Integer detailId, requestDetails updated )
    {

        requestDetails details = detailsRepository.findAllById(detailId);


        if (details == null) {
            throw new ApiException("Not found");
        }

        details.setMedicine(updated.getMedicine());
        details.setQuantity(updated.getQuantity());
        detailsRepository.save(details);

    }






}
