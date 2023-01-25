package com.example.hw12.Controller;
import com.example.hw12.Tracker.Tracker;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/v1/tracker")


public class MainController {
      /* Create Task tracker system , Where you can get all the taks , add , remove , update taks
      Task Class : ID , title , description , status

    Create a new taks (title , description , status , deadline)
    Display all tasks .

    Update a task
    Delete a task

    Change the task status as done or not done
    Search for a task by given title*/

    ArrayList<Tracker> trackerobj = new ArrayList<>();

    @GetMapping("/get")
    public List<Tracker> Display() {
        //    Display all tasks .
        return trackerobj;
    }

    @PostMapping("/view")
    public String Adding(@RequestBody Tracker t) {

        //Create a new taks (title , description , status , deadline)
        trackerobj.add(t);

        return " Adding done";
    }

    @PutMapping("/update/{index}")
    public String update(@PathVariable int index, @RequestBody Tracker t) {

        //Create a new taks (title , description , status , deadline)
        trackerobj.set(index, t);
        return " Updated Done";
    }

    /**/

    @DeleteMapping("/delete/{index}")
    public String deleteTrackerById(@PathVariable int index) {

        trackerobj.remove(index);

        return " Delete Done";

    }


    @PutMapping("/change")
    public String changeStatue() {
        for (int i = 0; i < trackerobj.size(); i++) {
            if (trackerobj.get(i).getStatus() == "done")
                trackerobj.get(i).setStatus("not done");
            else trackerobj.get(i).setStatus("done");
        }

        return "Change Statue is Done";
    }


    @GetMapping("/return")
    public ArrayList<Tracker> Searchbytitle(@RequestBody String t) {
        //    Display all tasks .
        ArrayList<Tracker> resultList = new ArrayList<>();
        for (int i = 0; i < trackerobj.size(); i++) {
            if (trackerobj.get(i).getTitle() == t) {
                resultList.addAll((Collection<? extends Tracker>) trackerobj.get(i));
                return resultList;
            }

        }


        return resultList;
    }


}