package com.example.applicationinfo;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class ApplicationInfoRepository {

    private final EntityManager entityManager;

    public ApplicationInfoRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public ApplicationInfo getApplicationInfo() {
        return entityManager.createQuery("select a from ApplicationInfo a", ApplicationInfo.class).getResultList().stream()
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }
}
