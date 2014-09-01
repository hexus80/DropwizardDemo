package com.hexus.dropwizarddemo.api;

public class Counterparty {
    private String name;
    private long code;

    public Counterparty(String name, long code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public long getCode() {
        return code;
    }
}
