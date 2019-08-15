package com.owary.faora.patterns.decorator.builder.auth;

import com.owary.faora.patterns.decorator.builder.authsource.AuthSource;
import com.owary.faora.patterns.decorator.builder.extra.CsrfConfigurer;

import java.util.List;

/**
 * @author Mensur Owary
 */
public class OAuth2 implements Authentication{

    private AuthSource authSource;

    public OAuth2(AuthSource authSource) {
        this.authSource = authSource;
    }

    public CsrfConfigurer csrf() {
        return new CsrfConfigurer(this);
    }

    @Override
    public List<String> getFeatures() {
        List<String> features = authSource.getFeatures();
        features.add("OAuth 2.0");
        return features;
    }
}

