package com.focusmr.dblocator.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.LinkedList;
import java.util.List;

/**
 * Value object for list of {@link TnsNameXml}.
 */
@XmlRootElement(name = "tnsNames")
public class TnsNamesXml {

    @XmlElement(name = "tnsName")
    private List<TnsNameXml> l = new LinkedList<TnsNameXml>();

    public void add(TnsNameXml xml) {
        l.add(xml);
    }

    @XmlTransient
    @SuppressWarnings("unused")
    public List<TnsNameXml> getNames() {
        return l;
    }
}
