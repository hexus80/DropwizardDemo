package com.hexus.dropwizarddemo.resources;

import com.codahale.metrics.annotation.Metered;
import com.google.common.base.Strings;
import com.hexus.dropwizarddemo.api.Currency;
import com.hexus.dropwizarddemo.api.ResponseError;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/currencies")
@Produces(MediaType.APPLICATION_JSON)
@Api("/currencies")
public class Currencies {
    private static final Map<String, Currency> currencies = new HashMap<>();

    {
        currencies.put("EUR", new Currency("Euro", "EUR"));
        currencies.put("USD", new Currency("American Dollar", "USD"));
        currencies.put("GBP", new Currency("British Pound", "GBP"));
    }

    @GET
    @Metered
    @ApiOperation(value = "Get all currencies")
    public Collection<Currency> getCurrencies() {
        return currencies.values();
    }

    @GET
    @Path("/{code}")
    @ApiOperation(value = "Get a currency by its code")
    public Response getCurrency(@PathParam("code") @ApiParam(value="code", required = true, defaultValue = "GBP") String code) {
        if (Strings.isNullOrEmpty(code)) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Code is mandatory").build();
        } else {
            if (currencies.containsKey(code)) {
                Response response = Response.status(Response.Status.OK).entity(currencies.get(code)).build();
                return response;
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity(new ResponseError("No such currency")).build();
            }
        }
    }
}
