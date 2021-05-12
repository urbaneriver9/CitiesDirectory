import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class CitiesDirectory {
    private final ArrayList<City> citiesDirectory = new ArrayList<>();

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
            citiesDirectory.add(city);
        }
    }

    public void add(City city){
        citiesDirectory.add(city);
    }

    public void printCityDirectory(){
        citiesDirectory.forEach(System.out::println);
    }

    public void sortCityName(){
        citiesDirectory.stream()
                .sorted(Comparator.comparing(City::getName))
                .forEach(System.out::println);
    }

    public void sortCityAndRegion(){
        citiesDirectory.stream()
                .sorted(Comparator.comparing(City::getName))
                .sorted(Comparator.comparing(City::getRegion))
                .forEach(System.out::println);
    }

    public void largePopulationCity(){
        City[] cities = citiesDirectory.toArray(new City[0]);
        int index = 0;
        int population = 0;

        for(int i = 0; i < cities.length; i++){

            if(cities[i].getPopulation() > population){
                index = i;
                population = cities[i].getPopulation();
            }
        }
        System.out.printf("[%d] = %d", index, population);
    }
    public void citiesInRegion(){
        Map<String, Long> regions = citiesDirectory.stream().collect((Collectors.groupingBy(City::getDistrict, Collectors.counting())));
        for(String key : regions.keySet()){
            System.out.println(key + " - " + regions.get(key));
        }
    }
}