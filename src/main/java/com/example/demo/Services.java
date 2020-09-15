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
    private String newline = "<br>";
    private String homeButton = "<a href=\"/\">Go Home</a>";

    public String getWelcomeService() {

        return "Welcome" + "<br>" +
                "<a href=\"http://localhost:8080/getSingle\">/getSingle</a> - To get a cat joke." + "<br>" +
                "<a href=\"http://localhost:8080/getTen\">/getTen</a> - To get ten cat jokes." + "<br>" +
                "<a href=\"http://localhost:8080/getTenSortByDate\">/getTenSortByDate</a> - To get ten cat jokes sorted by date of creation." + "<br>" +
                "<a href=\"http://localhost:8080/contains?inputChar=x&number=1\">/contains?inputChar=x&number=1</a> - To see a fact, if inputChar x, appears 1 time(s) in the fact. " + "<br>" +
                "In the URL above x can be replaced with any one letter, upper and lower case is interchangeable and with both be counted." + "<br>" +
                "In the URL above 1 can be replaced with any positive whole number.";
    }

    public CatFacts getSingleService() throws Exception {

        URL catURL = new URL("https://cat-fact.herokuapp.com/facts/random");
        BufferedReader inputFromCatURL = new BufferedReader(new InputStreamReader(catURL.openStream()));
        CatFacts catFact = new Gson().fromJson(inputFromCatURL, CatFacts.class);
        inputFromCatURL.close();

        return catFact;
    }

    public ArrayList<CatFacts> getTenService() throws Exception {
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

    public String containsService(char inputChar, int number, String fact) {
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
            return fact + newline + newline + homeButton;
        } else {
            return "<header> <h1>Sorry, no luck.</h1>  <p> <a href=\"/\">Go Home</a> " +
                    "or <a href=\"javascript:window.location.href=window.location.href\"> refresh</a> to check against a new cat fact. </p> </header>";
        }

    }

    public String getNewline() {
        return newline;
    }

    public String getHomeButton() {
        return homeButton;
    }
}
