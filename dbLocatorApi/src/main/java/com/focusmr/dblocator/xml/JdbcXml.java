package com.focusmr.dblocator.xml;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Value object for list of {@link JdbcXml}.
 */
@XmlRootElement(name = "jdbc")
@SuppressWarnings(value = "unused")
public class JdbcXml {

    private String connectionString;
    private String country;
    private String hostname;
    private Integer port;
    private String sid;
    private String serviceName;

    public String getConnectionString() {
        return connectionString;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

    public String getCountry() {
        return country;
    }

    public String getHostname() {
        return hostname;
    }

    public Integer getPort() {
        return port;
    }

    public String getSid() {
        return sid;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    @Override
    public String toString() {
        return connectionString;
    }
}
