package com.example.continent;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class ContinentRepository {

    private final EntityManager entityManager;

    public ContinentRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Continent findContinentByName(String continent) {
        return entityManager.createQuery("select c from Continent c where c.name = :name", Continent.class)
                .setParameter("name", continent)
                .getSingleResult();
    }
}
