package com.hexus.dropwizarddemo;

import com.hexus.dropwizarddemo.resources.Counterparties;
import com.hexus.dropwizarddemo.resources.Currencies;
import com.hexus.dropwizarddemo.resources.DemoResource;
import com.hexus.dropwizarddemo.resources.Tenors;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class MyApplication extends Application<MyApplicationConfiguration> {

    public static void main(String[] args) throws Exception {
        new MyApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<MyApplicationConfiguration> myApplicationConfigurationBootstrap) {

    }

    @Override
    public void run(MyApplicationConfiguration myApplicationConfiguration, Environment environment) throws Exception {
        final DemoResource resource = new DemoResource(myApplicationConfiguration.getTemplate(), myApplicationConfiguration.getDefaultName());
        environment.jersey().register(resource);

        final Counterparties counterparties = new Counterparties();
        environment.jersey().register(counterparties);

        final Tenors tenors  = new Tenors();
        environment.jersey().register(tenors);

        final Currencies currencies = new Currencies();
        environment.jersey().register(currencies);
    }
}
