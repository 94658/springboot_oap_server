package com.soap.ics;

import localhost._7000.soap_server.University;

import java.util.HashMap;
import java.util.Map;

public class UniversityRepository {

    private static final Map<String, University> universities = new HashMap<>();


    private void loadData() {
        // initialize countries map
        University strath = new University();
        strath.setName("Strathmore");
        strath.setLocation("Madaraka");
        strath.setYearFounded(1960);
        universities.put(strath.getName(),strath);

        University jkuat = new University();
        jkuat.setName("JKUAT");
        jkuat.setLocation("Juja");
        jkuat.setYearFounded(1980);
        universities.put(jkuat.getName(),jkuat);

        University ku = new University();
        ku.setName("Kenyatta University");
        ku.setLocation("Ruiru");
        ku.setYearFounded(1980);
        universities.put(ku.getName(),ku);

    }

    public University getUniversityByName(String name){
        return universities.get(name);
    }
}
