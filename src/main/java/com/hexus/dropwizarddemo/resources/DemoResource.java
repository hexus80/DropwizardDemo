package com.hexus.dropwizarddemo.resources;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import com.google.common.base.Strings;
import com.hexus.dropwizarddemo.api.Saying;
import com.wordnik.swagger.annotations.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
@Api("/hello")
public class DemoResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public DemoResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    @ApiOperation(value = "Hello world endpoint", response = Saying.class)
//    @ApiImplicitParam(value="defaultName", name="defaultName", defaultValue="Stranger", dataType="string", paramType = "query", access = "internal")
    public Saying sayHello(
            @ApiParam(value = "defaultName", required = false, defaultValue = "Stranger")

            @QueryParam("defaultName") String name
//            @QueryParam("defaultName") Optional<String> name
    ) {
        final String value = String.format(template,
                Strings.isNullOrEmpty(name) ? defaultName : name
                //name.or(defaultName)
        );
        return
                //Response.ok(new Saying(counter.incrementAndGet(), value)).build();
                new Saying(counter.incrementAndGet(), value);
    }
}
