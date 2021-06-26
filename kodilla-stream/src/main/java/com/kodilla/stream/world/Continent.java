package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Continent {
    private final List<Country> countries = new ArrayList<>();
    private final String name;

    public Continent(String continentName) {
        this.name = continentName;
    }

    public String getContinentName() {
        return name;
    }

    public List<Country> getListOfCountriesOnContinent() {
        return new ArrayList<>(countries);
    }

    public boolean addCountry (Country country){
        return countries.add(country);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Continent continent = (Continent) o;

        return Objects.equals(name, continent.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
