package com.focusmr.dblocator.xml;


import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 */
public class JdbcXmlTest {
    @Test
    public void testAdd() {
        final JdbcXml jdbcXmlTest = new JdbcXml();
        jdbcXmlTest.setConnectionString("abc");
        assertThat(jdbcXmlTest.getConnectionString(), equalTo("abc"));
    }
}
