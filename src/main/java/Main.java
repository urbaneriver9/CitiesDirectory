import Dao.CitiesDirectoryDao;
import services.CitiesDirectoryParser;
import services.CitiesDirectorySort;
import сonfiguration.Path;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] Args) throws FileNotFoundException {
        CitiesDirectoryParser cp = new CitiesDirectoryParser(new CitiesDirectoryDao());
        cp.cityParser("/Users/a19187978/IdeaProjects/Cities Directory/src/test/resources/SixCities.txt");
        CitiesDirectoryDao citiesDirectoryDao = cp.getCitiesDirectoryDao();
        CitiesDirectorySort cs = new CitiesDirectorySort(citiesDirectoryDao);
        cs.getCitiesInRegions();

    }
}
