package at.focusmr.dblocator.jdbc;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Holds JDBC String for Oracle database.
 */
@XmlRootElement
public class JdbcString {
    private String jdbc;

    public JdbcString(String jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public String toString() {
             return jdbc;
    }
}
