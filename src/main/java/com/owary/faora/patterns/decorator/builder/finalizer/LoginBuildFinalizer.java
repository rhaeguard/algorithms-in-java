package com.owary.faora.patterns.decorator.builder.finalizer;

import com.owary.faora.patterns.decorator.builder.extra.ExtrasConfigurer;
import com.owary.faora.patterns.decorator.builder.model.Login;

import java.util.List;

/**
 * @author Mensur Owary
 */
public class LoginBuildFinalizer {

    private ExtrasConfigurer extrasConfigurer;
    private boolean enabled;

    public LoginBuildFinalizer(ExtrasConfigurer extrasConfigurer, boolean enabled) {
        this.extrasConfigurer = extrasConfigurer;
        this.enabled = enabled;
    }

    public Login build() {
        List<String> features = extrasConfigurer.getFeatures();
        return new Login(features);
    }
}
