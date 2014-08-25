package com.hexus.dropwizarddemo;

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

    }
}
