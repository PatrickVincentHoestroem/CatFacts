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

    public ArrayList<CatFacts> get10service() throws Exception {

        ArrayList<CatFacts> catList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            URL catURL = new URL("https://cat-fact.herokuapp.com/facts/random");
            BufferedReader inputFromCatURL = new BufferedReader(new InputStreamReader(catURL.openStream()));
            CatFacts catFact = new Gson().fromJson(inputFromCatURL, CatFacts.class);
            catList.add(catFact);
            inputFromCatURL.close();

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
    public String containsService(char a , int n,String fact ) throws Exception {

        int count = 0;
        for (int i = 0; i <fact.length() ; i++) {
            if( fact.toLowerCase().charAt(i)=='a'){
                count++;
            }
        }
        if(count==n){
            return  fact;
        }else{
            return "Sorry no luck";
        }
    }


}
