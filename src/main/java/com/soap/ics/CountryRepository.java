package com.soap.ics;

import localhost._7000.soap_server.Country;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

public class CountryRepository {

    private static final Map<String, Country> countries = new HashMap<>();

    @PostConstruct
    public void initData() {
        // initialize countries map
    }

    public Country findCountry(String name) {
        return countries.get(name);
    }
}
