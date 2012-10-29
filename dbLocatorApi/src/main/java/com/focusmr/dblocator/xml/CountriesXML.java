package com.focusmr.dblocator.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.LinkedList;
import java.util.List;

/**
 * Maps countries XML to java.
 * <pre>
 *  {@code
 *  <countries>
 * <country>hr</country>
 * <country>hu</country>
 * <country>ru</country>
 * <country>sk</country>
 * <country>ua</country>
 * <country>be</country>
 * <country>lt</country>
 * <country>mk</country>
 * <country>se</country>
 * <country>detest</country>
 * <country>it</country>
 * <country>cz</country>
 * <country>ee</country>
 * <country>ch</country>
 * <country>si</country>
 * <country>nl</country>
 * <country>pt</country>
 * <country>ro</country>
 * <country>ba</country>
 * <country>de</country>
 * <country>rs</country>
 * <country>bg</country>
 * <country>pl</country>
 * <country>es</country>
 * <country>lv</country>
 * </countries>
 *
 *  }
 *  </pre>
 */
@XmlRootElement(name = "countries")
public class CountriesXML {

    @XmlElement(name = "country")
    private List<String> l = new LinkedList<String>();

    public void add(String xml) {
        l.add(xml);
    }

    @XmlTransient
    @SuppressWarnings("unused")
    public List<String> getCountries() {
        return l;
    }
}
