package com.example.country;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@ApplicationScoped
public class CountryRepository {

    private final EntityManager entityManager;

    public CountryRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Country> getAllCountries() {
        return entityManager.createQuery("select c from Country c", Country.class).getResultList();
    }

    public void addCountry(Country country) {
        entityManager.persist(country);
    }

    public void deleteCountry(Long id) {
        Country country = entityManager.find(Country.class, id);
        entityManager.remove(country);
    }

}
