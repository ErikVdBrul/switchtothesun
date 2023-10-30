package com.example.attraction;

import com.example.country.Country;
import jakarta.persistence.*;

@Entity
@Table(name = "ATTRACTION")
public class Attraction {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "attraction_seq")
    @SequenceGenerator(name = "attraction_seq", sequenceName = "attraction_seq", allocationSize = 1)
    private long id;
    @Column(name = "NAME")
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE")
    private AttractionType type;

    @ManyToOne
    @JoinColumn(name = "FK_COUNTRY_ID")
    private Country country;

    public Attraction(String name, Country country) {
        this.name = name;
        this.country = country;
    }

    public Attraction() {

    }

    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public AttractionType getType() {
        return type;
    }

    public Country getCountry() {
        return country;
    }

    @Override
    public String toString(){
        return name + " - " + country;
    }
}
