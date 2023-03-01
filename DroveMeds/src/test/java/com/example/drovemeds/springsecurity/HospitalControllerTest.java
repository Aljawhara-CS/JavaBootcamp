package com.example.drovemeds.springsecurity;

import com.example.drovemeds.Controller.HospitalController;
import com.example.drovemeds.Controller.MedicineController;
import com.example.drovemeds.Model.*;
import com.example.drovemeds.Service.HospitalService;
import com.example.drovemeds.Service.MedicineService;
import com.example.drovemeds.Service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@ExtendWith(SpringExtension.class)
@WebMvcTest(value = HospitalController.class , excludeAutoConfiguration = {SecurityAutoConfiguration.class})

public class HospitalControllerTest {


    @MockBean
    HospitalService hospitalService;



    @Autowired
    MockMvc mockMvc;

    List<Medicine> medicineList;
    List<Hospital> hospitalList;



    User myUser;
    Patient myPatient;
    Hospital myHospital;

    HospitalAdmin hospitalAdmin;

    Medicine myMedicine;

    @BeforeEach
    void setUp() {

        hospitalAdmin= new HospitalAdmin(null,"Admin","a","Approved",myUser,myHospital);

        myHospital= new Hospital(1,"King Fisal","KFHRC","KSA","Riyadh",null,null,null);
        myPatient = new Patient( null,"Ahmad","Ali","24", "KSA","Riyadh","1234","0546783439","Ahmad@gmail.com","M",13000,null,null, null,myHospital);



        myUser= new User(1,"CentralAdmin","juju@gmail.com","123",null,null);


        myMedicine = new Medicine(1,"medicine",30,null,5,"ML",400,"Bag","Manafactory1","KSA"," 20 degree",null,null);

        medicineList=Arrays.asList(myMedicine);

        hospitalList=Arrays.asList(myHospital);
        myHospital.setHospitalAdmins(Arrays.asList(hospitalAdmin));



    }





    //5

    @Test
    public void addHospitalTest() throws Exception

    {  mockMvc.perform(post("/api/v1/hospital/CentralAdmin/add")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content( new ObjectMapper().writeValueAsString(myHospital)))
            .andExpect(status().isOk());
    }

    @Test
    public void DeleteHospitalTest() throws Exception

    {

        mockMvc.perform(delete("/api/v1/hospital/CentralAdmin/delete/{id}",myMedicine.getId()))
                .andExpect(status().isOk());
    }


}