import at.focusmr.dblocator.jdbc.JdbcString;
import at.focusmr.dblocator.util.JdbcStringBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.util.logging.Logger;

public class JdbcStringBuilderTest {
    Logger log = Logger.getAnonymousLogger();
    @Test
    public void shouldGenerateCorrectSidString() {
        String result = "jdbc:oracle:thin:@glob01.focusmr.co.at:1521:AEMGLOB.FOCUSMR";
        JdbcStringBuilder b = new JdbcStringBuilder();
        b.withHost("glob01.focusmr.co.at");
        b.withPort(1521);
        b.withSid("AEMGLOB.FOCUSMR");
        JdbcString s = b.build();

        Assert.assertEquals(result, s.toString());

    }

    @Test
    public void shouldGenerateCorrectServiceString() {
        String result = "jdbc:oracle:thin:@//orac01.focusmr.co.at:1521/WEBDB1.FOCUSMR";
        JdbcStringBuilder b = new JdbcStringBuilder();
        b.withHost("orac01.focusmr.co.at");
        b.withPort(1521);
        b.withService("WEBDB1.FOCUSMR");
        JdbcString s = b.build();

        Assert.assertEquals(result, s.toString());

    }
    @Test(expected = IllegalStateException.class)
    public void testCreatingWithoutSidAndService() {

        JdbcStringBuilder b = new JdbcStringBuilder();
        b.build();
    }

    @Test
    public void testGeneratingJdbcString() {
        JdbcStringBuilder b = new JdbcStringBuilder();
        b.withHost("glob01.focusmr.co.at");
        b.withUser("db_locator");
        b.withPassword("nvvo4fx6");
        b.withPort(1521);
        b.withService("aemglob.focusmr");
        JdbcString jdbcString = b.build();
        log.info(jdbcString.toString());

    }

}
