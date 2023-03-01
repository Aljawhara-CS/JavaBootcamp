package com.example.drovemeds.springsecurity;

import com.example.drovemeds.Model.*;
import com.example.drovemeds.Repository.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class RepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    MedicineRepository medicineRepository;

    @Autowired
    HospitalRepository hospitalRepository;
  //  Request request1,request2,request3;
    User myUser;
    Patient myPatient;
    Hospital myHospital;

    Medicine myMedicine;


    @BeforeEach
    void setUp() {
        myUser= new User(null,"HospitalAdmin","juju@gmail.com","123",null,null);

        myHospital= new Hospital(null,"King Fisal","KFHRC","KSA","Riyadh",null,null,null);
        myPatient = new Patient( null,"Ahmad","Ali","24", "KSA","Riyadh","1234","0546783439","Ahmad@gmail.com","M",13000,null,null, null,null);
        myMedicine = new Medicine(null,"Banddoal",30,null,5,"ML",400,"Bag","Manafactory1","KSA"," 20 degree",null,null);

     /*   request1 = new Request
        request2 = new Request(null , "todo2", myUser );
        request3 = new Request(null , "todo3", myUser )*/;
    }

    @Test
    public void findUsersByUserIdTesting()
    {
        userRepository.save(myUser);
        User user= userRepository.findUsersByUserId(myUser.getUserId());
        Assertions.assertThat(user.getUserId()).isEqualTo(myUser.getUserId());
    }

   @Test
    public void findUserByEmailTesting(){


       userRepository.save(myUser);

       User user= userRepository.findUserByEmail(myUser.getEmail());

        Assertions.assertThat(myUser).isEqualTo(user);
    }

    @Test
    public void findPatientByPatientIdTesting(){


        patientRepository.save(myPatient);

        Patient patient= patientRepository.findPatientByPatientId(myPatient.getPatientId());

        Assertions.assertThat(myPatient).isEqualTo(patient);
    }

    @Test
    public void findMedicineByIdTesting()
    {

        medicineRepository.save(myMedicine);

        Medicine medicine= medicineRepository.findMedicineById(myMedicine.getId());

        Assertions.assertThat(myMedicine).isEqualTo(medicine);

    }

    @Test
    public void findHospitalByIdTesting()
    {

        hospitalRepository.save(myHospital);

        Hospital hospital= hospitalRepository.findHospitalById(myHospital.getId());

        Assertions.assertThat(myHospital).isEqualTo(hospital);

    }








}