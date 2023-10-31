package com.example.continent;

import jakarta.persistence.*;
import com.example.country.Country;

import java.util.List;

@Entity
@Table(name = "CONTINENT")
public class Continent {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "continent_seq")
    @SequenceGenerator(name = "continent_seq", sequenceName = "continent_seq", allocationSize = 1)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @OneToMany
    @JoinColumn(name = "FK_CONTINENT_ID")
    private List<Country> countryList;

    public Continent() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Country> getCountryList() {
        return countryList;
    }
}
