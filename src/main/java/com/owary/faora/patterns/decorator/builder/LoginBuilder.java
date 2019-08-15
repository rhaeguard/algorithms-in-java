package com.owary.faora.patterns.decorator.builder;

import com.owary.faora.patterns.decorator.builder.authsource.DatabaseAuth;
import com.owary.faora.patterns.decorator.builder.authsource.InMemoryAuth;
import com.owary.faora.patterns.decorator.builder.model.Login;

/**
 *
 * @author Mensur Owary
 */
public class LoginBuilder {

    public static DatabaseAuth databaseAuthentication() {
        return new DatabaseAuth();
    }

    public static InMemoryAuth inMemoryAuthentication(){
        return new InMemoryAuth();
    }
}
