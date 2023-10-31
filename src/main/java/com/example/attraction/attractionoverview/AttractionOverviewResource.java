package com.example.attraction.attractionoverview;

import com.example.attraction.AttractionRepository;
import jakarta.validation.constraints.NotEmpty;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.jboss.resteasy.reactive.RestQuery;


@Path("attraction-overview")
public class AttractionOverviewResource {

    private final AttractionRepository attractionRepository;

    public AttractionOverviewResource(AttractionRepository attractionRepository) {
        this.attractionRepository = attractionRepository;
    }

    @GET
    public AttractionOverview getAttractionOverviewByAttraction(@RestQuery @NotEmpty String attractionName) {
        return attractionRepository.findAttractionByName(attractionName).getAttractionOverview();
    }
}