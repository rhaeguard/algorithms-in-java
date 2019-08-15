package com.owary.faora.patterns.decorator.builder.auth;

import com.owary.faora.patterns.decorator.builder.authsource.AuthSource;
import com.owary.faora.patterns.decorator.builder.extra.CsrfConfigurer;

import java.util.List;

/**
 * @author Mensur Owary
 */
public class HttpBasic implements Authentication{

    private AuthSource authSource;

    public HttpBasic(AuthSource authSource) {
        this.authSource = authSource;
    }

    public CsrfConfigurer csrf() {
        return new CsrfConfigurer(this);
    }

    @Override
    public List<String> getFeatures() {
        List<String> features = authSource.getFeatures();
        features.add("HttpBasic");
        return features;
    }
}
