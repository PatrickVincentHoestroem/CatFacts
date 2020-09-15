package com.example.demo;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class Services {

    public CatFacts getSingleService() throws Exception {

        URL catURL = new URL("https://cat-fact.herokuapp.com/facts/random");
        BufferedReader inputFromCatURL = new BufferedReader(new InputStreamReader(catURL.openStream()));
        CatFacts catFact = new Gson().fromJson(inputFromCatURL, CatFacts.class);
        inputFromCatURL.close();

        return catFact;
    }

    public ArrayList<CatFacts> get10Service() throws Exception {
        ArrayList<CatFacts> catList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            catList.add(getSingleService());
        }
        return catList;
    }

    public String catListToString(ArrayList<CatFacts> catList) {
        String result = "";

        for (int i = 0; i < catList.size(); i++) {
            result += "joke Nr. " + (i + 1) + " - " + catList.get(i).getText() + " - Created at  "
                    + catList.get(i).getCreatedAt() + " - Updated at " + catList.get(i).getUpdatedAt() + "<br>";
        }
        return result;
    }


    public String catListSortedToString(ArrayList<CatFacts> catList) {
        String result = "";

        for (int i = 0; i < catList.size(); i++) {
            result += "joke Nr. " + (i + 1) + " - " + catList.get(i).getText() + " - Created at  "
                    + catList.get(i).getCreatedAt() + "<br>";
        }
        return result;
    }

    public String containsService(char inputChar, int number, String fact) throws Exception {
        int count = 0;

        if (Character.isLowerCase(inputChar)) {
            for (int i = 0; i < fact.length(); i++) {
                if (fact.toLowerCase().charAt(i) == inputChar) {
                    count++;
                }
            }

        }
        if (Character.isUpperCase(inputChar)) {
            for (int i = 0; i < fact.length(); i++) {
                if (fact.toUpperCase().charAt(i) == inputChar) {
                    count++;
                }
            }

        }
        if (count == number) {
            return fact + "<br>" + "<br>" + "<a href=\"/\">Go Home</a> ";
        } else {
            return "<header> <h1>Sorry, no luck.</h1>  <p> <a href=\"/\">Go Home</a> " +
                    "or <a href=\"javascript:window.location.href=window.location.href\"> refresh</a> to check against a new cat fact. </p> </header>";
        }

    }
}
