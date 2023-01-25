package com.example.hw14.Controller;

import com.example.hw14.POJO.Employees;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/Employees")
public class MainEmployees {

    ArrayList<Employees> empobj = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Employees> getemployees()
    {
        return empobj;
    }

    @PostMapping("/add")
    public ResponseEntity add_employee(@Valid @RequestBody Employees employees, Errors errors)
    {

        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        empobj.add(employees);
        return ResponseEntity.status(200).body(" Employee Added!!");

    }

    @PutMapping("/update/{index}")
    public ResponseEntity update_employee(@Valid @RequestBody Employees employee,@PathVariable int index,Errors errors)
    {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        empobj.set(index,employee);
        return ResponseEntity.status(200).body("Employee updated!!");
    }

    @DeleteMapping ("/delete/{index}")
    public ResponseEntity delete_employee(@PathVariable int index,Errors errors)
    {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        empobj.remove(index);
        return ResponseEntity.status(200).body("Employee Deleted!!");
    }

    @PutMapping("/leave")
    public ResponseEntity update_leave(@Valid @RequestBody Employees employee,Errors errors)
    {

        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        for (int i=0; i< empobj.size();i++ ) {
            if ( empobj.get(i).getId() ==employee.getId()) {

                if (empobj.get(i).isOnLeave() == false &&
                        (empobj.get(i).getAnnualLeave() != 0 && employee.getAnnualLeave() < empobj.get(i).getAnnualLeave()))
                {
                    empobj.get(i).setOnLeave(true);
                    int days=employee.getAnnualLeave() -empobj.get(i).getAnnualLeave();
                    empobj.get(i).setAnnualLeave(days);

                    return ResponseEntity.status(200).body("Employee updated to be on leave for " +employee.getAnnualLeave());

                } else
                    return ResponseEntity.status(400).body("Employee on leave or You don't have days in Your Annual Leave !!");
            }
        }

        return ResponseEntity.status(200).body("Employee updated to be on leave!!");
    }


}
