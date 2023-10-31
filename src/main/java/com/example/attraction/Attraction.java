package com.example.attraction;

import com.example.attraction.attractionoverview.AttractionOverview;
import com.example.country.Country;
import com.example.tourist.Tourist;
import jakarta.persistence.*;

import java.util.List;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_ATTRACTION_OVERVIEW")
    private AttractionOverview attractionOverview;
    @ManyToMany
    @JoinTable(name = "TOURIST_ATTRACTION",
            joinColumns = @JoinColumn(name = "ATTRACTION_ID"),
            inverseJoinColumns = @JoinColumn(name = "TOURIST_ID"))
    private List<Tourist> touristList;


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
    public AttractionOverview getAttractionOverview() {
        return attractionOverview;
    }

    public List<Tourist> getTouristList() {
        return touristList;
    }

    @Override
    public String toString(){
        return name + " - " + country;
    }
}
