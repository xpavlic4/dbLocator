package com.focusmr.dblocator.rest;

import com.focusmr.dblocator.data.TnsName;
import com.focusmr.dblocator.model.Databases;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**

 */
public class TnsNamesResourceRESTServiceTest {
    @Test
    public void testHappyPath() {
        final TnsNamesResourceRESTService tnsNamesResourceRESTService = new TnsNamesResourceRESTService();
        Databases d = new Databases();
        d.setCountry("at");
        d.setHostname("oradev");
        d.setPort(8080);
        d.setServiceName("serviceName");
        d.setTnsName("a");
        final TnsName tnsName = tnsNamesResourceRESTService.fromDatabase(d);
        assertTrue(tnsName.getValue().contains("oradev"));
    }
}
