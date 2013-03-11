package com.focusmr.dblocator.xml;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 */
public class JdbcTest {
    @Test
    public void testGetValue() throws Exception {
        final Jdbc jdbc = new Jdbc("test");
        assertThat(jdbc.getValue(), equalTo("test"));
    }
}
