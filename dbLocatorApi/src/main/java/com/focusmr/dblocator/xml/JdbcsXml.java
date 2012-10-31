package com.focusmr.dblocator.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.LinkedList;
import java.util.List;

/**
 */
@SuppressWarnings("unused")
@XmlRootElement(name = "jbdcs")
public class JdbcsXml {

    @XmlElement(name = "jdbc")
    private List<JdbcXml> jdbcs = new LinkedList<JdbcXml>();

    public void add(JdbcXml xml) {
        jdbcs.add(xml);
    }

    public List<JdbcXml> getJdbcs() {
        return jdbcs;
    }
}
