package objects;

public class City {

    private final String name;
    private final String region;
    private final String district;
    private int population;
    private final String foundation;
    private final int cityHash;

    public City(String name, String region, String district, String population, String foundation){
        this.name = name;
        this.region = region;
        this.district = district;
        this.population = Integer.parseInt(population);
        this.foundation = foundation;
        cityHash = name.hashCode()
                + region.hashCode()
                + district.hashCode()
                + population.hashCode()
                + foundation.hashCode();

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

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getFoundation() {
        return foundation;
    }

    public int getCityHash() {
        return cityHash;
    }

    @Override
    public String toString(){
        return "City{name='" + getName() +
                "', region='" + getRegion() +
                "', district='" + getDistrict() +
                "', population=" + getPopulation() +
                ", foundation='" + getFoundation() +
                "'}";
    }

}
