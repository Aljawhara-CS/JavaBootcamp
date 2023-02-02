package com.example.central_pharmacy.Repository;

import com.example.central_pharmacy.Model.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface LinkRepository extends JpaRepository<Link,Integer> {

    Link findByRequestId(Integer id);


}
