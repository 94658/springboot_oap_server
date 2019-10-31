package com.soap.ics;

import localhost._7000.universities.University;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UniversityRepository {

    private static final Map<String, University> universities = new HashMap<>(); //to hold data

    @PostConstruct
    private void loadData() {
        University strath = new University();
        strath.setLocation("Ole Sangale");
        strath.setName("Strathmore");
        strath.setYearFounded(1960);
        universities.put(strath.getName(), strath);

        University jkuat = new University();
        jkuat.setLocation("Juja");
        jkuat.setName("JKUAT");
        jkuat.setYearFounded(1990);
        universities.put(jkuat.getName(), jkuat);

        University riara = new University();
        riara.setLocation("Mbagathi");
        riara.setName("Riara");
        riara.setYearFounded(2003);
        universities.put(riara.getName(), riara);
    }

    public University getUniversityByName(String name) {
        return universities.get(name);
    }


    public List<University> getAllUniversities(){
        return new ArrayList<>(universities.values());
    }
}
