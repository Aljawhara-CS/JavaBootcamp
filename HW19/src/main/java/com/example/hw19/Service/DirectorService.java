package com.example.hw19.Service;

import com.example.hw19.Exception.ApiException;
import com.example.hw19.Model.Director;
import com.example.hw19.Repostry.DirectorRepostry;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class DirectorService {


    public final DirectorRepostry directorRepostry;


    public List<Director> getDirctors()
    {

        return directorRepostry.findAll();
    }

    public  void  addDirector (Director director)

    {
        directorRepostry.save(director);

    }

    public  void  UpdateDirector (Director director, Integer id)
    {

        Director old= directorRepostry.findDirectorById(id);

        if(old==null) {
                    throw new ApiException(" Director not found");

            }

            old.setName(director.getName());
            directorRepostry.save(director);

    }


    public  void  DeleteDirector (Integer id)
    {
        Director found= directorRepostry.findDirectorById(id);
        if(found!=null)
        {
            directorRepostry.deleteById(id);
        }

          else throw new ApiException(" Director not found");

    }









}
