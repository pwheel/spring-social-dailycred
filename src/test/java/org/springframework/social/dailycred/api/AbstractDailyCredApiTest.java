package org.springframework.social.dailycred.api;

import org.junit.Before;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.social.dailycred.api.impl.DailyCredTemplate;
import org.springframework.test.web.client.MockRestServiceServer;

/**
 * Provides utility methods for implementing tests.
 *
 * @author paul.wheeler
 */
public class AbstractDailyCredApiTest {

    protected static final String ACCESS_TOKEN = "someAccessToken";

    protected DailyCredTemplate dailyCred;
    protected MockRestServiceServer mockServer;

    @Before
    public void setup() {
        dailyCred = createFacebookTemplate();
        mockServer = MockRestServiceServer.createServer(dailyCred.getRestTemplate());
    }

    protected DailyCredTemplate createFacebookTemplate() {
        return new DailyCredTemplate(ACCESS_TOKEN);
    }

    protected Resource jsonResource(String filename) {
        return new ClassPathResource(filename + ".json", getClass());
    }

}
