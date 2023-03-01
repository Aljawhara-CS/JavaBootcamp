package com.example.drovemeds.springsecurity;

import com.example.drovemeds.Model.*;
import com.example.drovemeds.Repository.HospitalRepository;
import com.example.drovemeds.Repository.MedicineRepository;
import com.example.drovemeds.Repository.PatientRepository;
import com.example.drovemeds.Repository.UserRepository;
import com.example.drovemeds.Service.HospitalService;
import com.example.drovemeds.Service.MedicineService;
import com.example.drovemeds.Service.PatientService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class ServiceTest {

    @InjectMocks
    HospitalService hospitalService;
    @InjectMocks
    MedicineService medicineService;

    @InjectMocks
    PatientService patientService;


    @Mock
    HospitalRepository hospitalRepository;
    @Mock
    MedicineRepository medicineRepository;

    @Mock
    PatientRepository patientRepository;




    @Mock
    UserRepository userRepository;




  //  Request request1,request2,request3;
    User myUser;
    Patient myPatient;
    Hospital myHospital;

    HospitalAdmin hospitalAdmin;

    Medicine myMedicine;
String name;

    @BeforeEach
    void setUp() {

        myHospital= new Hospital(null,"King Fisal","KFHRC","KSA","Riyadh",null,null,null);
        myPatient = new Patient( null,"Ahmad","Ali","24", "KSA","Riyadh","1234","0546783439","Ahmad@gmail.com","M",13000,null,null, null,myHospital);

        hospitalAdmin= new HospitalAdmin(null,"Admin","a","Approved",myUser,myHospital);

        myUser= new User(1,"HospitalAdmin","juju@gmail.com","123",null,hospitalAdmin);


        myMedicine = new Medicine(null,"Banddoal",30,null,5,"ML",400,"Bag","Manafactory1","KSA"," 20 degree",null,null);
       name ="King Fisal";
     /*   request1 = new Request
        request2 = new Request(null , "todo2", myUser );
        request3 = new Request(null , "todo3", myUser )*/;
    }


    //1

   // @Test
   public void addHospitalTest()
    {
         hospitalService.addHospital(myHospital);
        verify(hospitalRepository, times(1)).save(myHospital);

    }

    //2
  //  @Test
    public void addMedicineTest()
    {
        medicineService.addMedicine(myMedicine);
        verify(medicineRepository, times(1)).save(myMedicine);

    }

    //3
  // @Test
    public void addPatient()
    {
        when(patientRepository.findPatientByPatientId(myPatient.getPatientId())).thenReturn(myPatient);
        when(userRepository.findUsersByUserId(myUser.getUserId())).thenReturn(myUser);

        patientService.addPatient(myPatient,myUser);

        verify(userRepository, times(1)).findUsersByUserId(myUser.getUserId());
        verify(patientRepository, times(1)).save(myPatient);


    }

    //4
   // @Test
    public void getAllMedicineTest()
    {
        medicineService.getAllMedicine();
        verify(medicineRepository, times(1)).findAll();


    }

    //5
   // @Test
    public void getMedicineByIdTest()
    {
        medicineService.getMedicineById(myMedicine.getId());
        verify(medicineRepository, times(1)).findMedicineById(myMedicine.getId());

    }



}