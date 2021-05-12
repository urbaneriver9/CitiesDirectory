public class City {

    private String name;
    private String region;
    private String district;
    private int population;
    private String foundation;

    City(String name, String region, String district, String population, String foundation){
        this.name = name;
        this.region = region;
        this.district = district;
        this.population = Integer.parseInt(population);
        this.foundation = foundation;
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public String getDistrict() {
        return district;
    }

    public int getPopulation() {
        return population;
    }

    public String getFoundation() {
        return foundation;
    }

    @Override
    public String toString(){
        return "City{name='" + getName() +
                "', region='" + getRegion() +
                "', district='" + getRegion() +
                "', population=" + getPopulation() +
                ", foundation='" + getFoundation() +
                "'}";
    }
}
