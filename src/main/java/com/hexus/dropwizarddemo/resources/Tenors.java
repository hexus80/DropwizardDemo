package com.hexus.dropwizarddemo.resources;

import com.google.common.base.Strings;
import com.hexus.dropwizarddemo.api.Tenor;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;


@Path("/tenors")
@Api("/tenors")
@Produces(MediaType.APPLICATION_JSON)
public class Tenors {
    @GET
    @ApiOperation(value = "List of all tenors")
    public List<Tenor> getTenors() {
        return Arrays.asList(Tenor.values());
    }

    @GET
    @Path("/{id}")
    @ApiOperation(value = "Specific tenor by its id")
    public Tenor getTenor(@PathParam(value = "id") @ApiParam(name="id", required = true, defaultValue = "D1") String id) {
        if(Strings.isNullOrEmpty(id)) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        } else {
            try {
                return Tenor.valueOf(id);
            } catch (IllegalArgumentException e) {
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
        }

    }
}
