package com.focusmr.dblocator.xml;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 */
public class JdbcsXmlTest {
    @Test
    public void testAdd() throws Exception {
        final JdbcsXml jdbcsXml = new JdbcsXml();
        final JdbcXml xml = new JdbcXml();
        xml.setCountry("at");
        jdbcsXml.add(xml);
        final List<JdbcXml> jdbcs = jdbcsXml.getJdbcs();
        assertThat(jdbcs.size(), is(1));
    }
}
