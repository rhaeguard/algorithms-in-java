package com.owary.faora.patterns.decorator.builder.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mensur Owary
 */
public class Login {

    private List<String> features = new ArrayList<>();

    public Login(List<String> features) {
        this.features = features;
    }

    public void printFeatures() {
        features.forEach(System.out::println);
    }

}
