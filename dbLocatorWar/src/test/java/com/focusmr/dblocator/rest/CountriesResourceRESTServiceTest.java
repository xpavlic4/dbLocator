package com.focusmr.dblocator.rest;

import com.focusmr.dblocator.data.TnsName;
import com.focusmr.dblocator.model.Databases;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 */
public class CountriesResourceRESTServiceTest {
    @Test
    public void testFromDatabase() throws Exception {
        final CountriesResourceRESTService countriesResourceRESTService = new CountriesResourceRESTService();
        final Databases d = new Databases();
        d.setSid("sid");
        d.setServiceName("serviceName");
        d.setHostname("hostname");
        d.setCountry("coutry");
        d.setPort(1115);
        d.setCountry("a");
        d.setTnsName("tns");
        final TnsName tnsName = countriesResourceRESTService.fromDatabase(d);
        assertTrue(tnsName.getValue().contains("hostname"));
    }
}
