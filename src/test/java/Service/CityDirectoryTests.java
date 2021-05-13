package Service;

import Dao.CitiesDirectoryDao;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.rules.ErrorCollector;
import services.CitiesDirectoryParser;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;


public class CityDirectoryTests {

    CitiesDirectoryParser cityDirParser = new CitiesDirectoryParser(new CitiesDirectoryDao());
    CitiesDirectoryDao citiesDirectoryDao;


    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @BeforeEach
    public void setup(){
        cityDirParser = new CitiesDirectoryParser(new CitiesDirectoryDao());
    }

    @Test
    public void threeCitiesFile() throws FileNotFoundException {
        cityDirParser.cityParser("/Users/a19187978/IdeaProjects/Cities Directory/src/test/resources/ThreeCity.txt");
        citiesDirectoryDao = cityDirParser.getCitiesDirectoryDao();
        assertEquals("City{name='Адыгейск', region='Адыгея', district='Южный', population=12248, foundation='1973'}\n" +
                        "City{name='Горно-Алтайск', region='Алтай', district='Сибирский', population=56928, foundation='1830'}\n" +
                        "City{name='Амурск', region='Хабаровский край', district='Дальневосточный', population=42977, foundation='1958'}",
                citiesDirectoryDao.citiesDirectoryString());
    }

    @Test
    public void duplicate() throws FileNotFoundException{
        cityDirParser.cityParser("/Users/a19187978/IdeaProjects/Cities Directory/src/test/resources/DublicateCities.txt");
        citiesDirectoryDao = cityDirParser.getCitiesDirectoryDao();
        assertEquals("City{name='Адыгейск', region='Адыгея', district='Южный', population=12248, foundation='1973'}",
                citiesDirectoryDao.citiesDirectoryString());
    }

    @Test
    public void sortByName() throws FileNotFoundException{
        cityDirParser.cityParser("/Users/a19187978/IdeaProjects/Cities Directory/src/test/resources/SixCities.txt");
        citiesDirectoryDao = cityDirParser.getCitiesDirectoryDao();

        assertEquals("City{name='Абаза', region='Хакасия', district='Сибирский', population=17111, foundation='1867'}\n" +
                "City{name='Адыгейск', region='Адыгея', district='Южный', population=12248, foundation='1973'}\n" +
                "City{name='Алдан', region='Якутия', district='Дальневосточный', population=21277, foundation='1924'}\n" +
                "City{name='Амурск', region='Хабаровский край', district='Дальневосточный', population=42977, foundation='1958'}\n" +
                "City{name='Горно-Алтайск', region='Алтай', district='Сибирский', population=56928, foundation='1830'}\n" +
                "City{name='Майкоп', region='Адыгея', district='Южный', population=144246, foundation='1857'}",
                citiesDirectoryDao.sortCityName());
    }

    @Test
    public void sortByNameAndRegion() throws FileNotFoundException{
        cityDirParser.cityParser("/Users/a19187978/IdeaProjects/Cities Directory/src/test/resources/SixCities.txt");
        citiesDirectoryDao = cityDirParser.getCitiesDirectoryDao();

        assertEquals("City{name='Алдан', region='Якутия', district='Дальневосточный', population=21277, foundation='1924'}\n" +
                        "City{name='Амурск', region='Хабаровский край', district='Дальневосточный', population=42977, foundation='1958'}\n" +
                        "City{name='Абаза', region='Хакасия', district='Сибирский', population=17111, foundation='1867'}\n" +
                        "City{name='Горно-Алтайск', region='Алтай', district='Сибирский', population=56928, foundation='1830'}\n" +
                        "City{name='Адыгейск', region='Адыгея', district='Южный', population=12248, foundation='1973'}\n" +
                        "City{name='Майкоп', region='Адыгея', district='Южный', population=144246, foundation='1857'}",
                citiesDirectoryDao.sortCityAndRegion());
    }

    @Test
    public void largestPopulationTest() throws FileNotFoundException{
        cityDirParser.cityParser("/Users/a19187978/IdeaProjects/Cities Directory/src/test/resources/SixCities.txt");
        citiesDirectoryDao = cityDirParser.getCitiesDirectoryDao();

        assertEquals("[1] = 144246",
                citiesDirectoryDao.largePopulationCity());
    }

    @Test
    public void citiesInRegionsTest() throws FileNotFoundException{
        cityDirParser.cityParser("/Users/a19187978/IdeaProjects/Cities Directory/src/test/resources/SixCities.txt");
        citiesDirectoryDao = cityDirParser.getCitiesDirectoryDao();
        Map<String, Long> expected = new HashMap<>();
        expected.put("Южный", 2L);
        expected.put("Сибирский", 2L);
        expected.put("Дальневосточный", 2L);

        collector.checkThat(citiesDirectoryDao.citiesInRegions(), is(expected));
    }
}

