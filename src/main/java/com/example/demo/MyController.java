package com.example.demo;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

@Controller

public class MyController {

    @GetMapping("/")
    @ResponseBody

    public String welcome() {

        return "Welcome";
    }

    @GetMapping("/getSingle")
    @ResponseBody

    public String getSingle() throws Exception {

        URL catURL = new URL("https://cat-fact.herokuapp.com/facts/random");
        BufferedReader inputFromCatURL = new BufferedReader(new InputStreamReader(catURL.openStream()));
        CatFacts catFact = new Gson().fromJson(inputFromCatURL, CatFacts.class);
        inputFromCatURL.close();

        return catFact.toString();
    }

    @GetMapping("/getTen")
    @ResponseBody
    public String getTen() throws Exception {
        ArrayList<CatFacts> catList = new ArrayList<>();
        Services services = new Services();
         catList=services.get10service();

        return catList.toString();
    }

}
