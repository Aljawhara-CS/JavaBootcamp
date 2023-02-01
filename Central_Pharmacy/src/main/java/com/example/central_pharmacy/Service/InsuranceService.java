package com.example.central_pharmacy.Service;

import com.example.central_pharmacy.Exception.ApiException;
import com.example.central_pharmacy.Model.Insurance;
import com.example.central_pharmacy.Repository.InsuranceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class InsuranceService {
    public final InsuranceRepository insuranceRepository;

    public List<Insurance> getInsuranceCompany()

    {
        return insuranceRepository.findAll();

    }

    public void  addInsuranceCompany( Insurance insurance)

    {
         insuranceRepository.save(insurance);
    }

    public void  updateInsuranceCompany( Insurance insurance, Integer id)

    {

        Insurance old = insuranceRepository.findByInsuranceId(id);
        if (old==null)
        {         throw new ApiException(" Insurance Company  not found");
        }

        old.setName(insurance.getName());
        old.setPatientId(insurance.getPatientId());
        insuranceRepository.save(old);
    }

    public void  deleteInsuranceCompany( Integer id)

    {

        Insurance old = insuranceRepository.findByInsuranceId(id);
        if (old !=null)
        {

           insuranceRepository.deleteById(id);
        }

         throw new ApiException(" Insurance Company not found");



    }








}
