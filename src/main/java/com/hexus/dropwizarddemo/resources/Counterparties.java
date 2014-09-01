package com.hexus.dropwizarddemo.resources;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import com.hexus.dropwizarddemo.api.Counterparty;
import com.hexus.dropwizarddemo.api.Saying;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/counterparties")
@Produces(MediaType.APPLICATION_JSON)
public class Counterparties {
    @GET
    @Timed
    public List<Counterparty> getCounterparties(@QueryParam("code")Optional<Long> code) {
        if(!code.isPresent()) {
            List<Counterparty> counterpartyList = new ArrayList<>(3);
            counterpartyList.add(new Counterparty("RBS", 1));
            counterpartyList.add(new Counterparty("Morgan Stanley", 2));
            counterpartyList.add(new Counterparty("CityBank", 3));
            counterpartyList.add(new Counterparty("Barclays", 4));
            return counterpartyList;
        } else {
            //TODO: add a specific counterparty selection
            return new ArrayList<>();
        }
    }
}
