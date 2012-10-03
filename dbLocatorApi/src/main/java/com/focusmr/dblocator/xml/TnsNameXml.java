package com.focusmr.dblocator.xml;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Holds TNS Names String for Oracle database.
 */
@XmlRootElement(name = "tnsName")
public class TnsNameXml {

    private String tnsName;
    private String country;
    private String nlsLang;

    public TnsNameXml() {
    }

    @SuppressWarnings(value = "unused")
    public String getTnsName() {
        return tnsName;
    }

    public void setTnsName(String tnsName) {
        this.tnsName = tnsName;
    }

    @SuppressWarnings(value = "unused")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return tnsName;
    }

    public String getNlsLang() {
        return nlsLang;
    }

    public void setNlsLang(String nlsLang) {
        this.nlsLang = nlsLang;
    }
}
