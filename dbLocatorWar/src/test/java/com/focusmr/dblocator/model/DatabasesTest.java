package com.focusmr.dblocator.model;

import org.junit.Test;

import java.lang.annotation.Annotation;

import static org.junit.Assert.assertTrue;

/**
 */
public class DatabasesTest {
    @Test
    public void testConstructor() {
        final Databases databases = new Databases();
        databases.setCategory("A");
        databases.setCountry("B");
    }

    @Test
    public void testHasAnotation() {
        final Annotation[] annotations = Databases.class.getAnnotations();
        assertTrue(annotations.length > 1);
    }

}
