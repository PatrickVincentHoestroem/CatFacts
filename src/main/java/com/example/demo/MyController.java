package com.example.demo;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class MyController {

@GetMapping("/")
    @ResponseBody

    public String welcome (){

    return "Welcome";
}
}
