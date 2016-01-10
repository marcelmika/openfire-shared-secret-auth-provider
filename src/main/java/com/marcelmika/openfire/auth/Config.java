package com.marcelmika.openfire.auth;

import org.jivesoftware.util.JiveProperties;

import java.util.Map;

/**
 * Provides access to the configuration required for creating
 * <code>SharedSecretAuthenticationProvider</code> instance.
 *
 * @author Ing. Marcel Mika
 * @link http://marcelmika.com
 * Date: 09/01/16
 * Time: 18:11
 */
public class Config {

    // Key corresponding to the shared secret
    private static final String SHARED_SECRET = "sharedSecretAuthProvider.sharedSecret";

    // Map of configuration properties
    private Map<String, String> configProperties;

    /**
     * Constructs instance of <code>Config<code/>
     */
    public Config() {

        // Get the properties
        JiveProperties properties = JiveProperties.getInstance();

        if (properties == null) {
            throw new IllegalArgumentException(
                    "Configuration properties not defined"
            );
        }

        this.configProperties = properties;
    }

    /**
     * Get the shared secret. Corresponds to the configuration
     * value <code>sharedSecretAuthProvider.sharedSecret</code>
     *
     * @return Shared secret defined by the user, otherwise <code>null</code>
     */
    public String getSharedSecret() {
        return configProperties.get(SHARED_SECRET);
    }
}
