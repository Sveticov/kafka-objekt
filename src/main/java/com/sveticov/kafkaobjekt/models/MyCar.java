package com.sveticov.kafkaobjekt.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class MyCar {
    private String make;
    private String manufacturer;
    private String id;

    public MyCar() {
    }

    public MyCar(String make, String manufacturer, String id) {
        this.make = make;
        this.manufacturer = manufacturer;
        this.id = id;
    }
}
