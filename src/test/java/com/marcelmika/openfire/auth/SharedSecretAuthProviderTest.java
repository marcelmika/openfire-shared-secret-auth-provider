package com.marcelmika.openfire.auth;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Ing. Marcel Mika
 * @link http://marcelmika.com
 * Date: 05/01/16
 * Time: 09:13
 */
public class SharedSecretAuthProviderTest {

    private static final String AUTH_SUCCESS_USERNAME = "authorized_user";
    private static final String AUTH_SUCCESS_SECRET = "sdf123";
    private static final String AUTH_FAILURE_USERNAME = "unauthorized_user";
    private static final String AUTH_FAILURE_SECRET = "12345";

    // Tested class
    SharedSecretAuthProvider authProvider;

    /**
     * Set up the test object structure
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        authProvider = new SharedSecretAuthProvider();
    }

    /**
     * Plain is supported
     */
    @Test
    public void testIsPlainSupported() {
        assertTrue("Plain should be supported", authProvider.isPlainSupported());
    }

    /**
     * Digest is not supported
     */
    @Test
    public void testIsDigestSupported() {
        assertFalse("Digest should not be supported", authProvider.isDigestSupported());
    }

    /**
     * Digest is not supported
     *
     * @throws Exception
     */
    @Test(expected = java.lang.UnsupportedOperationException.class)
    public void testAuthenticateDigest() throws Exception {
        authProvider.authenticate(AUTH_FAILURE_USERNAME, AUTH_FAILURE_SECRET, "digest");
    }

    /**
     * Get password is not supported
     *
     * @throws Exception
     */
    @Test(expected = java.lang.UnsupportedOperationException.class)
    public void testGetPassword() throws Exception {
        authProvider.getPassword(AUTH_FAILURE_USERNAME);
    }

    /**
     * Set password is not supported
     *
     * @throws Exception
     */
    @Test(expected = java.lang.UnsupportedOperationException.class)
    public void testSetPassword() throws Exception {
        authProvider.setPassword(AUTH_FAILURE_USERNAME, AUTH_FAILURE_SECRET);
    }

    /**
     * Password retrieval is not supported
     */
    @Test
    public void testSupportsPasswordRetrieval() {
        assertFalse("Password retrieval should not be supported", authProvider.supportsPasswordRetrieval());
    }
}
