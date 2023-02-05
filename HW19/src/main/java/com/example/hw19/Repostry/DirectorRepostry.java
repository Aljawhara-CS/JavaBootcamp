package com.example.hw19.Repostry;

import com.example.hw19.Model.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepostry extends JpaRepository<Director,Integer> {


    Director findDirectorById(Integer id);
}
