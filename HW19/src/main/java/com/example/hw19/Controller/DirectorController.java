package com.example.hw19.Controller;

import com.example.hw19.Model.Director;
import com.example.hw19.Service.DirectorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/director")
@RequiredArgsConstructor

public class DirectorController {

    private final DirectorService directorService;

    @GetMapping("/get")
    public ResponseEntity getDirectors()
    {
        List<Director> directors= directorService.getDirctors();
        return  ResponseEntity.status(200).body(directors);

    }

    @PostMapping("/add")
    public ResponseEntity addDirector(@Valid @RequestBody Director director)

    {


        directorService.addDirector(director);
        return ResponseEntity.status(200).body(" Director Added!");

    }


    @PutMapping("/update/{id}")
    public  ResponseEntity updateDirector(@PathVariable Integer id, @Valid@RequestBody  Director director)
    {

        directorService.UpdateDirector(director,id);
        return ResponseEntity.status(200).body("Director Updated");


    }


    @DeleteMapping("/delete/{id}")
    public  ResponseEntity deleteDirector(@PathVariable Integer id)
    {

        directorService.DeleteDirector(id);
        return ResponseEntity.status(200).body("Director Deleted");


    }



}
