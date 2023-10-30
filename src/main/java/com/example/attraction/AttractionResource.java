package com.example.attraction;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.RestQuery;

import java.util.List;
import java.util.Optional;

@Path("attractions")
public class AttractionResource {

    private final AttractionService attractionService;

    public AttractionResource(AttractionService attractionService) {
        this.attractionService = attractionService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<AttractionDTO> getAllAttractions(@RestQuery Optional<AttractionType> type,
                                                 @RestQuery Optional<String> country) {

        return type.map(attractionService::findAttractionsOfType)
                .or(() -> country.map(attractionService::findAttractionsInCountry))
                .orElseGet(attractionService::getAllAttractions);
    }
}
