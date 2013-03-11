package com.focusmr.dblocator.xml;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;


/**
 */
public class TnsNameXmlTest {
    @Test
    public void testXmlName() {
        final TnsNameXml tnsNameXml = new TnsNameXml();
        final String at = "at";
        tnsNameXml.setCountry(at);
        assertThat(tnsNameXml.getCountry(), equalTo("at"));
    }
}
