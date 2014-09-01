package com.hexus.dropwizarddemo.resources;

import com.codahale.metrics.annotation.Metered;
import com.hexus.dropwizarddemo.api.Currency;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/currencies")
@Produces(MediaType.APPLICATION_JSON)
public class Currencies {
    @GET
    @Metered
    public List<Currency> getCurrencies() {
        List<Currency> currencies = new ArrayList<>();
        currencies.add(new Currency("Euro", "EUR"));
        currencies.add(new Currency("American Dollar", "USD"));
        currencies.add(new Currency("British Pound", "GBP"));
        return currencies;
    }
}
