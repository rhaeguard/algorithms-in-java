package com.owary.faora.patterns.decorator.builder.authsource;

import com.owary.faora.patterns.decorator.builder.Featured;
import com.owary.faora.patterns.decorator.builder.auth.HttpBasic;
import com.owary.faora.patterns.decorator.builder.auth.OAuth2;

/**
 * @author Mensur Owary
 */
public interface AuthSource extends Featured {

    HttpBasic httpBasic();
    OAuth2 oAuth2();

}
