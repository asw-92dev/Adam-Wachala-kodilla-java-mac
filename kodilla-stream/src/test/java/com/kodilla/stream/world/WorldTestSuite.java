package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class WorldTestSuite {
    @Test
    public void testGetPeopleQuantity(){
        //Given
        World world = new World();

        Continent europa = new Continent("Europa");
        Continent asia = new Continent("Asia");
        Continent africa = new Continent("Africa");

        Country poland = new Country("Poland");
        Country hungary = new Country("Hungary");
        Country montenegro = new Country("Montenegro");
        Country bangkok = new Country("Bangkok");
        Country pekin = new Country("Pekin");
        Country tokio = new Country("Tokio");
        Country dakar = new Country("Dakar");
        Country cairo = new Country("Cairo");
        Country germany = new Country("Germany");

        world.addContinent(europa);
        world.addContinent(asia);
        world.addContinent(africa);

        europa.addCountry(poland);
        europa.addCountry(hungary);
        europa.addCountry(montenegro);
        europa.addCountry(germany);

        asia.addCountry(bangkok);
        asia.addCountry(pekin);
        asia.addCountry(tokio);

        africa.addCountry(dakar);
        africa.addCountry(cairo);

        //When

        BigDecimal totalPeople = world.getPeopleQuantity();
        //Then
        BigDecimal totalPeopleExpected = new BigDecimal("19122894081");
        Assert.assertEquals(totalPeopleExpected, totalPeople);
    }
}
