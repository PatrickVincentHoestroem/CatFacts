package com.example.demo;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class Services {

    public ArrayList<CatFacts> get10service() throws Exception{

        ArrayList<CatFacts> catList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            URL catURL = new URL("https://cat-fact.herokuapp.com/facts/random");
            BufferedReader inputFromCatURL = new BufferedReader(new InputStreamReader(catURL.openStream()));
            CatFacts catFact = new Gson().fromJson(inputFromCatURL, CatFacts.class);
            System.out.println(catFact);
            catList.add(catFact);
            inputFromCatURL.close();

        }


        return catList;
    }
}
