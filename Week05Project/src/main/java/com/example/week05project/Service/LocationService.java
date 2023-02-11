package com.example.week05project.Service;

import com.example.week05project.DTO.LocationDTO;
import com.example.week05project.Exception.ApiException;
import com.example.week05project.Model.Location;
import com.example.week05project.Model.Store;
import com.example.week05project.Repostry.LocationRepository;
import com.example.week05project.Repostry.StoreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class LocationService {


    private  final LocationRepository locationRepository;
  //  private  final StoreRepository storeRepository;
    private  final StoreService storeService;


    public  void addStoreLocation(LocationDTO cd)
    {
        Store store=storeService.getStoreById(cd.getStore_id());
        if(store==null)
        {
            throw  new ApiException("store not found");
        }

        Location Location= new Location(null,cd.getArea(),cd.getStreet(),store);
        locationRepository.save(Location);

    }


    public void updateStoreLocation(LocationDTO cd)
    {

        Location location=locationRepository.findLocationById(cd.getStore_id());
        if(location==null)
        {
            throw  new ApiException("Store's location not found");
        }

        location.setArea(cd.getArea());
        location.setStreet(cd.getStreet());

        locationRepository.save(location);

    }

    public void deleteStoreLocation(Integer id)
    {

        Location location=locationRepository.findLocationById(id);

        if(location==null)
        {
            throw  new ApiException("Store's Location not found");
        }


        locationRepository.delete(location);

    }




}
