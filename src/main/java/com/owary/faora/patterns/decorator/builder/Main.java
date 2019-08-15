package com.owary.faora.patterns.decorator.builder;

/**
 * @author Mensur Owary
 */
public class Main {

    public static void main(String[] args) {
        LoginBuilder
                    .inMemoryAuthentication()
                    .oAuth2()
                    .csrf().enable()
                    .build()
                .printFeatures();

    }

}
