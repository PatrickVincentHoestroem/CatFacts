package com.example.demo;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class Services {
    private String newLine = "<br>";
    private String homeButton = "<a href=\"/\">Go Home</a>";
    private String GetSingleButton = "<a href=\"http://localhost:8080/getSingle\">/getSingle</a>";
    private String getTenButton = "<a href=\"http://localhost:8080/getTen\">/getTen</a>";
    private String getTenSortByDateButton = "<a href=\"http://localhost:8080/getTenSortByDate\">/getTenSortByDate</a>";
    private String containsButton = "<a href=\"http://localhost:8080/contains?inputChar=x&number=1\">/contains?inputChar=x&number=1</a>";
    private String refreshButton = " <a href=\"javascript:window.location.href=window.location.href\"> refresh</a>";

    public String getWelcomeService() {

        return "Welcome" + newLine +
                GetSingleButton + " - To get a cat joke." + newLine +
                getTenButton + " - To get ten cat jokes." + newLine +
                getTenSortByDateButton + " - To get ten cat jokes sorted by date of creation." + newLine +
                containsButton + " - To see a fact, if inputChar x, appears 1 time(s) in the fact. " + newLine +
                "In the URL above x can be replaced with any one letter, upper and lower case is interchangeable and with both be counted." + newLine +
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
                    + catList.get(i).getCreatedAt() + " - Updated at " + catList.get(i).getUpdatedAt() + newLine;
        }
        return result;
    }


    public String catListSortedToString(ArrayList<CatFacts> catList) {
        String result = "";

        for (int i = 0; i < catList.size(); i++) {
            result += "joke Nr. " + (i + 1) + " - " + catList.get(i).getText() + " - Created at  "
                    + catList.get(i).getCreatedAt() + newLine;
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
            return fact + newLine + newLine + homeButton + " - " + refreshButton + " to check against a new cat fact.";
        } else {
            return "<header> <h1>Sorry, no luck.</h1>  <p> " + homeButton +
                    " or " + refreshButton + " to check against a new cat fact. </p> </header>";
        }

    }

    public String getNewLine() {
        return newLine;
    }

    public String getHomeButton() {
        return homeButton;
    }
}
