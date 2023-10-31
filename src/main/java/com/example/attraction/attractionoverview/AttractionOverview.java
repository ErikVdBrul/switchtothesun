package com.example.attraction.attractionoverview;

import jakarta.persistence.*;

@Entity
@Table(name = "ATTRACTION_OVERVIEW")
public class AttractionOverview {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "attraction_overview_seq")
    @SequenceGenerator(name = "attraction_overview_seq", sequenceName = "attraction_overview_seq", allocationSize = 1)
    private Long id;

    private int score;

    private String description;

    private double price;

    @Column(name = "VISITORS_PER_YEAR")
    private int visitorsPerYear;

    public AttractionOverview() {
    }

    public AttractionOverview(Long id, int score, String description, double price, int visitorsPerYear) {
        this.id = id;
        this.score = score;
        this.description = description;
        this.price = price;
        this.visitorsPerYear = visitorsPerYear;
    }

    public Long getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getVisitorsPerYear() {
        return visitorsPerYear;
    }
}