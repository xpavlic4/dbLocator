package com.focusmr.dblocator.client;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Test various client code.
 */
public class GenericRestClientTest {

    @Test
    public void testCallingHttp() throws Exception {
        final GenericRestClient genericRestClient = new GenericRestClient();
        final GenericRestClient.RequestBuilder requestBuilder = new GenericRestClient.RequestBuilder();
        requestBuilder.withContentType("text/plain").withMethod("GET").withURI("http://www.focusmr.com");
        final Object execute = genericRestClient.execute(requestBuilder.build());
        assertNotNull("Shouldn't be null", execute);

    }

    @Test
    public void testConvertingStreamToString() throws Exception {
        InputStream is = new ByteArrayInputStream("test".getBytes());
        final String s = GenericRestClient.convertStreamToString(is);
        assertEquals("test", s);

    }
}
