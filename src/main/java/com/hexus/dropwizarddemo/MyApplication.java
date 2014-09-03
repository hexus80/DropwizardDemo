package com.hexus.dropwizarddemo;

import com.hexus.dropwizarddemo.health.DemoHealthCheck;
import com.hexus.dropwizarddemo.resources.Counterparties;
import com.hexus.dropwizarddemo.resources.Currencies;
import com.hexus.dropwizarddemo.resources.DemoResource;
import com.hexus.dropwizarddemo.resources.Tenors;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerDropwizard;

public class MyApplication extends Application<MyApplicationConfiguration> {
    private final SwaggerDropwizard swaggerDropwizard = new SwaggerDropwizard();

    public static void main(String[] args) throws Exception {
        new MyApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<MyApplicationConfiguration> bootstrap) {
        swaggerDropwizard.onInitialize(bootstrap);
    }

    @Override
    public void run(MyApplicationConfiguration configuration, Environment environment) throws Exception {
        swaggerDropwizard.onRun(configuration, environment, "localhost");

        final DemoResource resource = new DemoResource(configuration.getTemplate(), configuration.getDefaultName());
        environment.jersey().register(resource);

        final Counterparties counterparties = new Counterparties();
        environment.jersey().register(counterparties);

        final Tenors tenors = new Tenors();
        environment.jersey().register(tenors);

        final Currencies currencies = new Currencies();
        environment.jersey().register(currencies);

        environment.healthChecks().register("DemoHealthCheck", new DemoHealthCheck(configuration.getTemplate()));
    }
}
