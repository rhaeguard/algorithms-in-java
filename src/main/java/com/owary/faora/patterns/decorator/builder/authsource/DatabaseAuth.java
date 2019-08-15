package com.owary.faora.patterns.decorator.builder.authsource;

import com.owary.faora.patterns.decorator.builder.auth.HttpBasic;
import com.owary.faora.patterns.decorator.builder.auth.OAuth2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mensur Owary
 */
public class DatabaseAuth implements AuthSource{

    private List<String> features;

    public DatabaseAuth() {
        this.features = new ArrayList<>();
        this.features.add("Database Authentication");
    }

    public HttpBasic httpBasic() {
        return new HttpBasic(this);
    }

    @Override
    public OAuth2 oAuth2() {
        return new OAuth2(this);
    }

    @Override
    public List<String> getFeatures() {
        return features;
    }
}