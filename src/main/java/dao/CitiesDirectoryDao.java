package Dao;

import objects.City;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class CitiesDirectoryDao {

    public final ArrayList<City> citiesDirectory = new ArrayList<>();

    public void add(City city){
        citiesDirectory.add(city);
    }

    public boolean isCityHash(int hash) {
        for (City city : citiesDirectory) {
            if (city.getCityHash() == hash) {
                return true;
            }
        }
        return false;
    }

    public String citiesDirectoryString() {
        StringBuilder result = new StringBuilder();
        citiesDirectory.stream()
                .forEach(c -> result.append(c.toString()).append(System.lineSeparator()));

        return result.toString().trim();
    }

    public String sortCityName() {
        StringBuilder result = new StringBuilder();
        citiesDirectory.stream()
                .sorted(Comparator.comparing(City::getName))
                .forEach(c -> result.append(c).append(System.lineSeparator()));

        return result.deleteCharAt(result.length() - 1).toString();
    }

    public String sortCityAndRegion() {
        StringBuilder result = new StringBuilder();
        citiesDirectory.stream()
                .sorted(Comparator.comparing(City::getName))
                .sorted(Comparator.comparing(City::getDistrict))
                .forEach(c -> result.append(c).append(System.lineSeparator()));

        return result.deleteCharAt(result.length() - 1).toString();
    }

    public String largePopulationCity() {
        City[] cities = citiesDirectory.toArray(new City[0]);
        int index = 0;
        int population = 0;

        for (int i = 0; i < cities.length; i++) {
            if (cities[i].getPopulation() > population) {
                index = i;
                population = cities[i].getPopulation();
            }
        }

        return ("[" + index + "]" + " = " + population);
    }

    public Map<String, Long> citiesInRegions() {
        return citiesDirectory.stream()
                .collect((Collectors.groupingBy(City::getDistrict, Collectors.counting())));
    }

    public void getCitiesDirectory(){
        System.out.println(citiesDirectoryString());
    }
}
