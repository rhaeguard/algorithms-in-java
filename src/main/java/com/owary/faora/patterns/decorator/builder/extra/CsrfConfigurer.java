package com.owary.faora.patterns.decorator.builder.extra;

import com.owary.faora.patterns.decorator.builder.auth.Authentication;
import com.owary.faora.patterns.decorator.builder.finalizer.LoginBuildFinalizer;

import java.util.List;

/**
 * @author Mensur Owary
 */
public class CsrfConfigurer implements ExtrasConfigurer {

    private Authentication authentication;

    private boolean enabled = false;

    public CsrfConfigurer(Authentication authentication) {
        this.authentication = authentication;
    }

    public LoginBuildFinalizer enable(){
        this.enabled = true;
        return new LoginBuildFinalizer(this, true);
    }

    public LoginBuildFinalizer disable(){
        return new LoginBuildFinalizer(this, false);
    }

    @Override
    public List<String> getFeatures() {
        List<String> features = authentication.getFeatures();
        features.add("Csrf "+(enabled ? "Enabled" : "Disabled"));
        return features;
    }
}
