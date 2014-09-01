package com.hexus.dropwizarddemo.health;

import com.codahale.metrics.health.HealthCheck;

public class DemoHealthCheck extends HealthCheck {
    public static final String TEST = "TEST";
    private String template;

    public DemoHealthCheck(String template) {
        this.template = template;
    }

    @Override
    protected Result check() throws Exception {
        String test = String.format(template, TEST);

        if (test.isEmpty() || !test.contains(TEST)) {
            return Result.unhealthy("Template is incorrect: " + template);
        }

        return Result.healthy();
    }
}
