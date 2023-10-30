package com.example.attraction;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@Transactional
public class AttractionService {

    private final AttractionRepository attractionRepository;

    public AttractionService(AttractionRepository attractionRepository) {
        this.attractionRepository = attractionRepository;
    }

    public List<AttractionDTO> getAllAttractions() {
        return attractionRepository.getAllAttractions()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public List<AttractionDTO> findAttractionsOfType(AttractionType type) {
        return attractionRepository.findAttractionsOfType(type)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public List<AttractionDTO> findAttractionsInCountry(String country) {
        return attractionRepository.findAttractionsInCountry(country)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private AttractionDTO toDTO(Attraction attraction) {
        return new AttractionDTO(attraction.getId(),
                attraction.getName(),
                attraction.getType(),
                attraction.getCountry());
    }
}