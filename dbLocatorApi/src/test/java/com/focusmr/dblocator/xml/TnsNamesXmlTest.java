package com.focusmr.dblocator.xml;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 */
public class TnsNamesXmlTest {
    @Test
    public void testAdd() throws Exception {
        final TnsNamesXml tnsNamesXml = new TnsNamesXml();
        final TnsNameXml xml = new TnsNameXml();
        xml.setCountry("at");
        tnsNamesXml.add(xml);

        assertThat(tnsNamesXml.getNames().size(), is(1));
    }
}
