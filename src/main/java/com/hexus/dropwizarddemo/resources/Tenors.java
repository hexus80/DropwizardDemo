package com.hexus.dropwizarddemo.resources;

import com.codahale.metrics.annotation.Gauge;
import com.hexus.dropwizarddemo.api.Tenor;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

@Path("/tenors")
@Produces(MediaType.APPLICATION_JSON)
public class Tenors {
    @GET
    @Gauge
    public List<Tenor> getTenors() {
        return Arrays.asList(Tenor.values());
    }
}
