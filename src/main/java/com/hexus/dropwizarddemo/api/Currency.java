package com.hexus.dropwizarddemo.api;

import org.hibernate.validator.constraints.Length;

public class Currency {
    private String name;
    @Length(max = 3)
    private String shortName;

    public Currency(String name, String shortName) {
        this.name = name;
        this.shortName = shortName;
    }

    public String getName() {
        return name;
    }

    public String getShortName() {
        return shortName;
    }
}
