package com.example.country;


import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.ResponseStatus;
import org.jboss.resteasy.reactive.RestPath;
import org.jboss.resteasy.reactive.RestQuery;

import java.util.List;
import java.util.Optional;

import static org.jboss.resteasy.reactive.RestResponse.StatusCode.CREATED;
import static org.jboss.resteasy.reactive.RestResponse.StatusCode.OK;

@Path("countries")
public class CountryResource {

    private final CountryService countryService;

    public CountryResource(CountryService countryService) {
        this.countryService = countryService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Country> getAllCountries(@RestQuery Optional<String> continent) {
        return countryService.getAllCountries();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @ResponseStatus(CREATED)
    public void addCountry(CountryDTO country) {
        countryService.addCountry(country);
    }

    @DELETE
    @Path("{id}")
    @ResponseStatus(OK)
    public void deleteCountry(@RestPath Long id) {
        countryService.deleteCountry(id);
    }
}