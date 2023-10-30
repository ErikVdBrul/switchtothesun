package com.example.country.geographicalinformation;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class GeographicalInformation {
    private int population;
    @Column(name = "land_area")
    private double landArea;

    private double gdp;

    public GeographicalInformation() {

    }

    public GeographicalInformation(int population, double landArea, double gdp) {
        this.population = population;
        this.landArea = landArea;
        this.gdp = gdp;
    }

    public int getPopulation() {
        return population;
    }

    public double getLandArea() {
        return landArea;
    }

    public double getGdp() {
        return gdp;
    }
}
