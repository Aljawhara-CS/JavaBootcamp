package com.example.drovemeds.Service;
import com.example.drovemeds.Exception.ApiException;
import com.example.drovemeds.Model.Medicine;
import com.example.drovemeds.Repository.MedicineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicineService {


    private final MedicineRepository medicineRepository;

    public List getAllMedicine() {

        return medicineRepository.findAll();
    }

    public Medicine getMedicineById( Integer medicineId) {

        return medicineRepository.findMedicineById(medicineId);
    }

    public void addMedicine(Medicine medicine) {

        medicineRepository.save(medicine);
    }

    public void updateMedicine(Integer id,Medicine medicine){

        Medicine oldmedicine=medicineRepository.getById(id);
        if(oldmedicine==null){
            throw new ApiException(" Medicine  not found");

        }


        oldmedicine.setName(medicine.getName());
        oldmedicine.setManufacturerCountry(medicine.getManufacturerCountry());
        oldmedicine.setManufacturerName(medicine.getManufacturerName());
        oldmedicine.setStorageConditions(medicine.getStorageConditions());
        oldmedicine.setPackageType(medicine.getPackageType());
        oldmedicine.setUnit(medicine.getUnit());
        oldmedicine.setVolume(medicine.getVolume());
        oldmedicine.setPrice(medicine.getPrice());
        oldmedicine.setExpire(medicine.getExpire());
        oldmedicine.setQuantity(medicine.getQuantity());


        medicineRepository.save(oldmedicine);

    }

    public void deleteMedicine(Integer id) {

        Medicine oldMadison=medicineRepository.getById(id);

        if (oldMadison == null) {

            throw new ApiException(" Medicine  not found");

        }
        medicineRepository.deleteById(id);



    }
    public Medicine getExpireDate(Integer id)
    {


        Medicine medicine=medicineRepository.getById(id);

        if(medicine==null){
            throw new ApiException(" Medicine  not found");

        }

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        List<Medicine> medicines = getAllMedicine();

       for (int i=0; i< medicines.size(); i++)

        if( (dtf.format(now)).equals(medicines.get(i).getExpire()) )
        {


        }

         return medicine;

    }






}
