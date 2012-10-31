package com.focusmr.dblocator.client;

import com.focusmr.dblocator.xml.JdbcXml;
import com.focusmr.dblocator.xml.JdbcsXml;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.core.MediaType;

/**
 * Client proxy for DbLocator REST webservice.
 */
@SuppressWarnings("unused")
public class DbLocatorRestClient extends RestClient {

    private String url;

    /**
     * Call webservice to obtain all JDBC strings.
     *
     * @return all JDBC strings or null if error
     */
    public JdbcsXml doGetJdbcs() {
        JdbcsXml xml;
        RequestBuilder rb = new RequestBuilder();
        rb.withURI(getUrl());
        rb.withMethod(HttpMethod.GET);
        rb.withContentType(MediaType.APPLICATION_XML);
        Request r = rb.build();

        Object execute = execute(r, JdbcsXml.class);
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
        rb.withURI(getUrl());
        rb.withMethod(HttpMethod.GET);
        rb.withContentType(MediaType.APPLICATION_XML);
        rb.withEntity(c.getCountry());
        Request r = rb.build();

        execute = (JdbcXml) execute(r, JdbcXml.class);
        return execute;
    }

    /**
     * Gets url.
     * e.g. http://localhost:8080/DbLocator/rest/databases/jdbcs/
     *
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets url.
     *
     * @param url url
     */
    public void setUrl(String url) {
        this.url = url;
    }
}
