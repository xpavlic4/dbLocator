package com.focusmr.dblocator.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
@XmlRootElement(name = "countries")
public class CountriesXML {
    @XmlElement(name = "country")
    private List<String> l = new LinkedList<String>();

    public void add(String xml) {
        l.add(xml);
    }
}
