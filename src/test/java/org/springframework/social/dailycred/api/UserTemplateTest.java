package org.springframework.social.dailycred.api;

import org.junit.Test;
import org.springframework.http.MediaType;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.test.web.client.match.RequestMatchers.*;
import static org.springframework.test.web.client.response.ResponseCreators.withSuccess;

/**
 * Tests that the expected responses and URLs are being used.
 *
 * @author paul.wheeler
 */
public class UserTemplateTest extends AbstractDailyCredApiTest {

    @Test
    public void getUserProfile_currentUser() {
        mockServer.expect(requestTo("https://www.dailycred.com/graph/me.json"))
                .andExpect(method(GET))
                .andExpect(header("Authorization", "Bearer someAccessToken"))
                .andRespond(withSuccess(jsonResource("testdata/profile"), MediaType.APPLICATION_JSON));

        DailyCredProfile profile = dailyCred.userOperations().getUserProfile();
        assertBasicProfileData(profile);
    }

    private void assertBasicProfileData(DailyCredProfile profile) {
        JsonMappingTest.assertJsonMappings(profile);
    }
}
