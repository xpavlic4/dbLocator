package com.focusmr.dblocator.xml;

import com.focusmr.dblocator.model.Databases;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Value object for list of {@link JdbcXml}.
 */
@XmlRootElement(name = "jdbc")
@SuppressWarnings(value = "unused")
public class JdbcXml {

    private String connectionString;
    private String country;
    private String hostName;
    private Integer port;
    private String sid;
    private String serviceName;

    public JdbcXml() {
    }

    /**
     * Copy constructor
     *
     * @param d database entry
     */
    public JdbcXml(Databases d) {
        country = d.getCountry();
        hostName = d.getHostname();
        port = d.getPort();
        sid = d.getSid();
        serviceName = d.getServiceName();
    }

    public String getConnectionString() {
        return connectionString;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

    public String getCountry() {
        return country;
    }

    public String getHostName() {
        return hostName;
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

    public void setHostName(String hostName) {
        this.hostName = hostName;
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
