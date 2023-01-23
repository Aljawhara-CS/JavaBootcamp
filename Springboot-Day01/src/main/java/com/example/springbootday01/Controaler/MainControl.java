package com.example.springbootday01.Controaler;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainControl {

    @GetMapping (path = "/name")
    public String name()
    {

        return "My name is .......";
    }

    @GetMapping (path = "/check_status")
    public String check_status ()
    {

        return " Everything OK";
    }
    @GetMapping (path = "/age")
    public String age ()
    {

        return "My age is ........";
    }

    @GetMapping (path = "/health")
    public String health ()
    {

        return "Server health is up and running";
    }

/*    Create Spring program with request on the following endpoints :

    Create a controller called welcomeController with the following endpoints

    GET /name : returns “My name is .......”
    GET /age : returns “My age is ........”
    GET /check/status : returns “Everything OK”
    GET /health : returns “Server health is up and running”*/
}
