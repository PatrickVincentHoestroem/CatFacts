package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Collections;

@Controller

public class MyController {

    @GetMapping("/")
    @ResponseBody

    public String welcome() {

        Services services = new Services();
        return services.getWelcomeService();
    }

    @GetMapping("/getSingle")
    @ResponseBody

    public String getSingle() throws Exception {

        Services services = new Services();

        return services.getSingleService().toString() + services.getNewLine() + services.getNewLine() + services.getHomeButton();

    }

    @GetMapping("/getTen")
    @ResponseBody
    public String getTen() throws Exception {

        Services services = new Services();

        return services.catListToString(services.getTenService()) + services.getNewLine() + services.getHomeButton();
    }

    @GetMapping("/getTenSortByDate")
    @ResponseBody
    public String getTenSortByDate() throws Exception {

        Services services = new Services();
        ArrayList<CatFacts> catList = services.getTenService();
        Collections.sort(catList);

        return services.catListSortedToString(catList) + services.getNewLine() + services.getHomeButton();
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
