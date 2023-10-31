package com.example.tourist;

import com.example.attraction.AttractionRepository;
import jakarta.validation.constraints.NotEmpty;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.jboss.resteasy.reactive.RestQuery;

import java.util.List;

@Path("tourists")
public class TouristResource {

    private final AttractionRepository attractionRepository;


    public TouristResource(AttractionRepository attractionRepository) {
        this.attractionRepository = attractionRepository;
    }

    @GET
    public List<Tourist> getTouristByAttraction(@NotEmpty @RestQuery String attraction) {
        return attractionRepository.findAttractionByName(attraction).getTouristList();
    }
}