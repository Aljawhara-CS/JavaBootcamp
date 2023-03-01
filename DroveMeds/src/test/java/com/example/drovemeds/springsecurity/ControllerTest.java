package com.example.drovemeds.springsecurity;

import com.example.drovemeds.Controller.MedicineController;
import com.example.drovemeds.Model.*;
import com.example.drovemeds.Repository.*;
import com.example.drovemeds.Service.HospitalAdminService;
import com.example.drovemeds.Service.HospitalService;
import com.example.drovemeds.Service.MedicineService;
import com.example.drovemeds.Service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


import com.fasterxml.jackson.core.JsonProcessingException;
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
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@ExtendWith(SpringExtension.class)
@WebMvcTest(value = MedicineController.class , excludeAutoConfiguration = {SecurityAutoConfiguration.class})

public class ControllerTest {

    @MockBean
    MedicineService medicineService;
    @MockBean
    HospitalService hospitalService;

    @MockBean
    UserService userService;


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

        myHospital= new Hospital(null,"King Fisal","KFHRC","KSA","Riyadh",null,null,null);
        myPatient = new Patient( null,"Ahmad","Ali","24", "KSA","Riyadh","1234","0546783439","Ahmad@gmail.com","M",13000,null,null, null,myHospital);



        myUser= new User(1,"CentralAdmin","juju@gmail.com","123",null,null);


        myMedicine = new Medicine(1,"medicine",30,null,5,"ML",400,"Bag","Manafactory1","KSA"," 20 degree",null,null);

        medicineList=Arrays.asList(myMedicine);

        hospitalList=Arrays.asList(myHospital);
        myHospital.setHospitalAdmins(Arrays.asList(hospitalAdmin));



    }


    //1


    @Test
    public void getAllMedicine() throws Exception {

        Mockito.when(medicineService.getAllMedicine()).thenReturn(medicineList);

        mockMvc.perform(get("/api/v1/medicine/get"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Banddoal"));
    }

//2
    @Test
    public void addMedicineTest() throws Exception

    {  mockMvc.perform(post("/api/v1/medicine/CentralAdmin/add")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content( new ObjectMapper().writeValueAsString(myMedicine)))
                    .andExpect(status().isOk());
    }

//3

    @Test
    public void DeleteMedicineTest() throws Exception{
        mockMvc.perform(delete("/api/v1/medicine/CentralAdmin/delete/{id}",myMedicine.getId()))
                .andExpect(status().isOk());
    }





}