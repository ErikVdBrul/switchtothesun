package com.example.attraction;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;

import java.util.List;

@ApplicationScoped
public class AttractionRepository {

    private final EntityManager entityManager;

    public AttractionRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Attraction> getAllAttractions() {
        return entityManager.createQuery("select a from Attraction a", Attraction.class).getResultList();
    }
    public List<Attraction> findAttractionsOfType(AttractionType type) {
        return entityManager.createQuery("select a from Attraction a where a.type = :type", Attraction.class)
                .setParameter("type", type)
                .getResultList();
    }

    public List<Attraction> findAttractionsInCountry(String country) {
        return entityManager.createQuery("select a from Attraction a where a.country.name = :country", Attraction.class)
                .setParameter("country", country)
                .getResultList();
    }
    public Attraction findAttractionByName(String attractionName) {
        return entityManager.createQuery("select a from Attraction a where a.name = :name", Attraction.class)
                .setParameter("name", attractionName)
                .getSingleResult();
    }
}
