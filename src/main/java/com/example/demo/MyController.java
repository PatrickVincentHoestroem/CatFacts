package com.example.demo;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

@Controller

public class MyController {

    @GetMapping("/")
    @ResponseBody

    public String welcome() {

        return "Welcome" + "<br>" +
                "<a href=\"http://localhost:8080/getSingle\">/getSingle</a> - To get a cat joke." + "<br>" +
                "<a href=\"http://localhost:8080/getTen\">/getTen</a> - To get ten cat jokes." + "<br>" +
                "<a href=\"http://localhost:8080/getTenSortByDate\">/getTenSortByDate</a> - To get ten cat jokes sorted by date of creation." + "<br>" +
                "<a href=\"http://localhost:8080/contains?inputChar=x&number=1\">/contains?inputChar=x&number=1</a> - To see a fact, if inputChar x, appears 1 time(s) in the fact. " + "<br>" +
                "In the URL above x can be replaced with any one letter, upper and lower case is interchangeable and with both be counted." + "<br>" +
                "In the URL above 1 can be replaced with any positive whole number.";
    }

    @GetMapping("/getSingle")
    @ResponseBody

    public String getSingle() throws Exception {

        Services services = new Services();

        return services.getSingleService().toString() + "<br>" + "<br>" + "<a href=\"/\">Go Home</a> ";
    }

    @GetMapping("/getTen")
    @ResponseBody
    public String getTen() throws Exception {

        Services services = new Services();

        return services.catListToString(services.get10Service()) + "<br>" + "<a href=\"/\">Go Home</a> ";
    }

    @GetMapping("/getTenSortByDate")
    @ResponseBody
    public String getTenSortByDate() throws Exception {

        Services services = new Services();
        ArrayList<CatFacts> catList = services.get10Service();
        Collections.sort(catList);

        return services.catListSortedToString(catList) + "<br>" + "<a href=\"/\">Go Home</a> ";
    }

    @GetMapping("/contains")
    @ResponseBody
    public String contains(char inputChar, int number) throws Exception {
        Services services = new Services();
        CatFacts catFact = services.getSingleService();
        String fact = catFact.getText();

        return services.containsService(inputChar, number, fact);
    }

}
