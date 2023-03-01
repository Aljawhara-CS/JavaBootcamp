package com.example.drovemeds.Service;

import com.example.drovemeds.Exception.ApiException;
import com.example.drovemeds.Model.Hospital;
import com.example.drovemeds.Model.Patient;
import com.example.drovemeds.Model.Request;
import com.example.drovemeds.Model.User;
import com.example.drovemeds.Repository.HospitalRepository;
import com.example.drovemeds.Repository.PatientRepository;
import com.example.drovemeds.Repository.RequestRepository;
import com.example.drovemeds.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor

public class PatientService {

    public final PatientRepository patientRepository;
    public final RequestRepository requestRepository;
    private  final HospitalRepository hospitalRepository;

    private  final UserRepository userRepository;



    public List<Patient> getPatients() {

        return patientRepository.findAll();
    }

    public List<Patient> getPatientsHospital(User userObj) {

      //  return patientRepository.findAllByUser(user);
        User user = userRepository.findUsersByUserId(userObj.getUserId());
        if (user==null)
        {
            throw new ApiException(" user not found!");
        }
        else return patientRepository.findAllByHospital(user.getHospitalAdmin().getHospital());


    }

    // get Patient by ID
    public Patient getPatient(Integer id,User userObj) {

        User user = userRepository.findUsersByUserId(userObj.getUserId());
        Patient patient= patientRepository.findPatientByPatientId(id);

        if (user==null || patient==null)
        {
            throw new ApiException(" user or patient not found!");
        }

        else if (patient.getHospital()==user.getHospitalAdmin().getHospital())

        {   return patientRepository.findPatientByPatientId(id);}

        throw new ApiException("patient not found!");
    }

    public void addPatient(Patient patient, User userObj) {

        User user = userRepository.findUsersByUserId(userObj.getUserId());

        if (user==null)
        {
            throw new ApiException(" user not found!");
        }
        else
        {
            patient.setHospital(user.getHospitalAdmin().getHospital());
            patient.setCity(user.getHospitalAdmin().getHospital().getCity());
            patient.setCountry(user.getHospitalAdmin().getHospital().getCountry());

            patientRepository.save(patient);
        }
       // assignPatientWithHospital(patient.getPatientId(),hospitalId);
    }


    public void assignPatientWithHospital(Integer patientId, Integer hospitalId)
    {
        Hospital hospitalObj= hospitalRepository.findHospitalById(hospitalId);
        Patient patientObj= patientRepository.findPatientByPatientId(patientId);
        if (hospitalObj==null|| patientObj==null)
        {
            throw new ApiException(" Patient or hospital not found!");
        }
else {
            patientObj.setCity(hospitalObj.getCity());
            patientObj.setCountry(hospitalObj.getCountry());

            patientObj.setHospital(hospitalObj);
            patientRepository.save(patientObj);
        }

    }

    public void updatePatient(Patient patient, Integer id,User userObj ) {

        Patient old = patientRepository.findPatientByPatientId(id);
        User user= userRepository.findUsersByUserId(userObj.getUserId());

        if (old == null || user==null) {
            throw new ApiException(" Patient and user not found");
        }
        else if (old.getHospital()==user.getHospitalAdmin().getHospital())
        {
            old.setFirstName(patient.getFirstName());
         old.setLastName(patient.getLastName());
        old.setAge(patient.getAge());
        old.setCity(user.getHospitalAdmin().getHospital().getCity());
        old.setCountry(user.getHospitalAdmin().getHospital().getCountry());
        old.setNationalAddress(patient.getNationalAddress());
        old.setPhone(patient.getPhone());
        old.setEmail(patient.getEmail());
        old.setBalance(patient.getBalance());
        old.setStartDate(patient.getStartDate());
        old.setLastDate(patient.getLastDate());


        patientRepository.save(old);}

    }

    public void deletePatient(Integer id,User userObj) {

        Patient found = patientRepository.findPatientByPatientId(id);
        User user=userRepository.findUsersByUserId(userObj.getUserId());

        if (found == null|| user == null) {
            throw new ApiException(" Patient or user  not found");
        }
       else if (found.getHospital()==user.getHospitalAdmin().getHospital())

        {patientRepository.deleteById(id);}



    }


// How many pationt has not valied insuranc

    public boolean doesInsuranceValid(Integer id) {

        Patient found = patientRepository.findPatientByPatientId(id);

        if (found == null)
        {
            throw new ApiException(" Patient  not found");
        }

        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();

       if (found.getLastDate().after(date))
       {
        return true;

       }

       return false;

}

// total number of Patient that had Delivered

    public Integer getPatientsDelivered()
    {
     List <Request> request = requestRepository.findRequestByStatusIsDelivered();
        return  request.size()-1;
    }



    }
