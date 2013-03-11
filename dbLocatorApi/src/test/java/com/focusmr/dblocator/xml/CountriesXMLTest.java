package com.focusmr.dblocator.xml;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 */
public class CountriesXMLTest {
    @org.junit.Test
    public void testAdd() throws Exception {
        final CountriesXML countriesXML = new CountriesXML();
        countriesXML.add("a");
        assertThat(countriesXML.getCountries().size(), is(1));
    }
}
