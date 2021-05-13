package services;

import Dao.CitiesDirectoryDao;
import objects.City;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;


public class CitiesDirectoryParser {

    public CitiesDirectoryDao citiesDirectoryDao;

    public CitiesDirectoryParser(CitiesDirectoryDao citiesDirectoryDao){
        this.citiesDirectoryDao = citiesDirectoryDao;
    }

    public CitiesDirectoryDao getCitiesDirectoryDao() {
        return citiesDirectoryDao;
    }

    public void cityParser(String path) throws FileNotFoundException {

        ArrayList<String[]> citiesInfo = new ArrayList<>();
        File file = new File(path);

        try (Scanner scanner = new Scanner(new FileReader(file))) {

            while (scanner.hasNext()) {
                String[] cityData = scanner.nextLine().split(";");
                citiesInfo.add(cityData);
            }
        }

        for(String[] cityData : citiesInfo){
            City city = new City(cityData[1],
                    cityData[2],
                    cityData[3],
                    cityData[4],
                    cityData[5]);
            if(citiesDirectoryDao.isCityHash(city.getCityHash())){
                continue;
            }
            citiesDirectoryDao.add(city);
        }


    }




}
