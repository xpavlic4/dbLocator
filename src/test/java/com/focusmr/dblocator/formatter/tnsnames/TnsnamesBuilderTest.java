package com.focusmr.dblocator.formatter.tnsnames;

import com.focusmr.dblocator.data.TnsNamesBuilder;
import com.focusmr.dblocator.util.FileUtils;
import junit.framework.Assert;
import org.junit.Test;

import java.net.URL;
import java.util.logging.Logger;

public class TnsnamesBuilderTest {

    @Test
    public void shouldFindTestFile() throws Exception {
        URL url = getClass().getResource("/test-service.ora");
        Logger.getAnonymousLogger().info(url.toString());
        String s2 = FileUtils.readFile(url.getPath());

        Assert.assertTrue(s2 != null);
        Assert.assertTrue(!s2.isEmpty());
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowExceptionIfNeitherServiceNameNorSidEntered() {

        TnsNamesBuilder b = new TnsNamesBuilder();
        b.withTnsName("ORA11");
        b.withHost("127.0.0.1");
        b.withPort(1521);
        b.build();
    }

    @Test
    public void shouldCheckServiceNameEntered() throws Exception {
        URL url = getClass().getResource("/test-service.ora");
        String result = FileUtils.readFile(url.getPath());
        result = result.replaceAll("\\s", "");

        TnsNamesBuilder b = new TnsNamesBuilder();
        b.withTnsName("ORA11");
        b.withHost("127.0.0.1");
        b.withPort(1521);
        b.withServiceName("ORA11");
        String s = b.build().getValue();

        Assert.assertEquals(result, s);
    }

    /**
     * test
     *
     * @throws Exception
     */
    @Test
    public void shouldCheckSidEntered() throws Exception {
        URL url = getClass().getResource("/test-sid.ora");
        String result = FileUtils.readFile(url.getPath());
        result = result.replaceAll("\\s", "");

        TnsNamesBuilder b = new TnsNamesBuilder();
        b.withTnsName("ORA11");
        b.withHost("127.0.0.1");
        b.withPort(1521);
        b.withSid("ORA11");
        String s = b.build().getValue();

        Assert.assertEquals(result, s);
    }
}
