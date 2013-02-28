package com.focusmr.dblocator.client;

import com.focusmr.dblocator.xml.JdbcXml;
import com.focusmr.dblocator.xml.JdbcsXml;

import java.net.URL;

/**
 * Client proxy for DbLocator REST webservice.
 */
@SuppressWarnings("unused")
public class DbLocatorRestClient extends GenericRestClient {

    private URL url;

    /**
     * Constructor with URL of webservice.
     *
     * @param url e.g. http://glob01:9090/DbLocator/rest/databases/jdbcs/
     */
    public DbLocatorRestClient(URL url) {
        this.url = url;
    }

    /**
     * Call webservice to obtain all JDBC strings.
     *
     * @return all JDBC strings or null if error
     */
    public JdbcsXml doGetJdbcs() {
        JdbcsXml xml;
        RequestBuilder rb = new RequestBuilder();
        rb.withURI(getUrl().toString());
        rb.withMethod("GET");
        rb.withContentType("application/xml");
        Request r = rb.build();

        Object execute;
        try {
            execute = execute(r, JdbcsXml.class);
        } catch (Exception e) {
            throw new DbLocatorException(e);
        }
        xml = (JdbcsXml) execute;

        return xml;
    }

    /**
     * Call webservice to obtain specific JDBC string for country.
     *
     * @param c country
     * @return JDBC connection string or null if error
     */
    public JdbcXml doGetJdbc(Country c) {
        JdbcXml execute;
        RequestBuilder rb = new RequestBuilder();
        rb.withURI(getUrl().toString());
        rb.withMethod("GET");
        rb.withContentType("application/xml");
        rb.withEntity(c.getCountry());
        Request r = rb.build();

        try {
            execute = (JdbcXml) execute(r, JdbcXml.class);
        } catch (Exception e) {
            throw new DbLocatorException(e);
        }
        return execute;
    }

    /**
     * Gets url.
     * e.g. http://localhost:8080/DbLocator/rest/databases/jdbcs/
     *
     * @return url
     */
    public URL getUrl() {
        return url;
    }

}
