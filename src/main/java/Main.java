import java.io.FileNotFoundException;

public class Main {

    public static CitiesDirectory citiesDirectory = new CitiesDirectory();

    public static void main(String[] args) throws FileNotFoundException {
        citiesDirectory.cityParser("/Users/a19187978/IdeaProjects/Cities Directory/Cities.txt");
    }
}
