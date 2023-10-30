package com.example.applicationinfo;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("application-info")
public class ApplicationInfoResource {

    private ApplicationInfoService applicationInfoService;

    public ApplicationInfoResource(ApplicationInfoService applicationInfoService) {
        this.applicationInfoService = applicationInfoService;
    }

    @GET
    @Path("/0")
    @Produces(MediaType.APPLICATION_JSON)
    public ApplicationInfo getApplicationInfo() {
        return applicationInfoService.getApplicationInfo();
    }

    @PUT
    @Path("/0")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateApplicationInfo(ApplicationInfo applicationInfo) {
        applicationInfoService.updateApplicationInfo(applicationInfo);
    }
}
