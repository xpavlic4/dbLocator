package com.focusmr.dblocator.data;

import com.focusmr.dblocator.formatter.jdbc.JdbcStringBuilder;
import com.focusmr.dblocator.model.Databases;

/**
 * Value object for JDBC connection string.
 */
public class Jdbc {
    /**
     * Constructs from {@link Databases}.
     *
     * @param d meta information about JDBC
     * @return new instance with given data
     */
    public static Jdbc from(Databases d) {
        JdbcStringBuilder b = new JdbcStringBuilder();
        b.withHost(d.getHostname());
        b.withPort(d.getPort());
        b.withService(d.getServiceName());
        b.withSid(d.getSid());
        return b.build();
    }

    public Jdbc(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return getValue();
    }
}
