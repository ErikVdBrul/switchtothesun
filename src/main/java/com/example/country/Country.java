package com.example.country;

import com.example.country.geographicalinformation.GeographicalInformation;
import jakarta.persistence.*;

@Entity
@Table(name = "COUNTRY")
public class Country {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "country_seq")
    @SequenceGenerator(name = "country_seq", sequenceName = "country_seq", allocationSize = 1)
    private long id;

    private String name;

    @Embedded
    private GeographicalInformation geographicalInformation;

    public Country() {
    }

    public Country(String name) {
        this.name = name;
    }
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public GeographicalInformation getGeographicalInformation() {
        return geographicalInformation;
    }

    public int getPopulation() {
        if (geographicalInformation == null) {
            return 0;
        }
        return geographicalInformation.getPopulation();
    }

    public double getLandArea() {
        if (geographicalInformation == null) {
            return 0;
        }
        return geographicalInformation.getLandArea();
    }

    public double getGdp() {
        if (geographicalInformation == null) {
            return 0;
        }
        return geographicalInformation.getGdp();
    }

    @Override
    public String toString() {
        return name;
    }
}

