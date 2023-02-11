package com.example.week05project.Repostry;

import com.example.week05project.Model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location,Integer> {


    Location findLocationById(Integer id);
}
