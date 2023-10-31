package com.example.tourist;

import jakarta.persistence.*;

@Entity
@Table(name = "TOURIST")
public class Tourist {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tourist_seq")
    @SequenceGenerator(name = "tourist_seq", sequenceName = "tourist_seq", allocationSize = 1)
    private Long id;

    @Column(name = "NAME")
    private String name;

    public Tourist() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}