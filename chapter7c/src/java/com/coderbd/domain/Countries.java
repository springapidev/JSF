package com.coderbd.domain;

import java.util.*;

public class Countries {

    private static Countries instance = new Countries();

    private List countries = new ArrayList();

    private Countries() {
        init();
    }

    private void init() {
        countries.add(new Country(1, "England"));
        countries.add(new Country(2, "Wales"));
        countries.add(new Country(3, "Scotland"));
        countries.add(new Country(4, "Bangladesh"));
        countries.add(new Country(5, "Australia"));
    }

    public static Countries getInstance() {
        return instance;
    }

    public Collection getCountries() {
        return Collections.unmodifiableCollection(countries);
    }

}
