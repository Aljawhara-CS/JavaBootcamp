package com.example.week05project.Repostry;

import com.example.week05project.Model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface StoreRepository extends JpaRepository<Store,Integer> {

//    Store findStoreById (Integer id);




}
