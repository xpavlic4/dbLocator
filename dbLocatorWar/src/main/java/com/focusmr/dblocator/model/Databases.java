package com.focusmr.dblocator.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@XmlRootElement
@Table
@NamedQueries({
        @NamedQuery(name = Databases.Q.ALL,
                query = "select d from Databases d  where d.category = 'dataentry'"),
        @NamedQuery(name = Databases.Q.BY_COUNTRY,
                query = "select m from Databases m where m.category = 'dataentry' and m.country = :country"),
        @NamedQuery(name = Databases.Q.DISTINCT_COUNTRY,
                query = "select distinct m.country from Databases m where m.category = 'dataentry'")
})
public class Databases implements Serializable {

    public void setCountry(String country) {
        this.country = country;
    }

    public static final class Q {

        private Q() {
        }

        public static final String ALL = "all";
        public static final String BY_COUNTRY = "BY_COUNTRY";
        public static final String DISTINCT_COUNTRY = "DISTINCT_COUNTRY";
    }

    /**
     * Default value included to remove warning. Remove or modify at will. *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "DB_ID")
    private int dbId;
    @Basic
    private String hostname;
    @Basic(optional = false)
    @Column(name = "TNSNAME")
    private String tnsName;
    @Basic(optional = true)
    private String sid;
    @Basic(optional = true)
    @Column(name = "service_name")
    private String serviceName;
    @Basic
    private int port;
    @Basic(optional = true)
    private String category;
    @Basic(optional = true)
    private String country;
    @Basic(optional = true)
    @Column(name = "NLS_LANG_SETTING")
    private String nlsLang;

    @Basic(optional = true)
    @Column(name = "DBVENDOR", columnDefinition = "char")
    private String dbVendor;

    //generated
    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getTnsName() {
        return tnsName;
    }

    public void setTnsName(String tnsname) {
        this.tnsName = tnsname;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCountry() {
        return country;
    }

    public String getNlsLang() {
        return nlsLang;
    }

    @SuppressWarnings("unused")
    public void setNlsLang(String nlsLang) {
        this.nlsLang = nlsLang;
    }

    public int getDbId() {
        return dbId;
    }

    public void setDbId(int dbId) {
        this.dbId = dbId;
    }

    public String getDbVendor() {
        return dbVendor;
    }

    public void setDbVendor(String dbVendor) {
        this.dbVendor = dbVendor;
    }
}