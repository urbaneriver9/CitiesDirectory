package services;

import Dao.CitiesDirectoryDao;

import java.util.Map;
import static Dao.CitiesDirectoryDao.*;

public class CitiesDirectorySort {

    public CitiesDirectoryDao citiesDirectoryDao;

    public CitiesDirectorySort(CitiesDirectoryDao citiesDirectoryDao){
        this.citiesDirectoryDao = citiesDirectoryDao;
    }

    public void getCitiesDirectorySortedByCityName(){
        System.out.println(citiesDirectoryDao.sortCityName());
    }

    public void getCitiesDirectorySortedByCityNameAndRegion(){
        System.out.println(citiesDirectoryDao.sortCityAndRegion());
    }

    public void getLargePopulationCity(){
        System.out.println(citiesDirectoryDao.largePopulationCity());
    }

    public void getCitiesInRegions(){
        Map<String, Long> regions = citiesDirectoryDao.citiesInRegions();
        for(String key : regions.keySet()){
            System.out.println(key + " - " + regions.get(key));
        }
    }
}

