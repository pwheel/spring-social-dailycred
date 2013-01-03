package org.springframework.social.dailycred.api;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Tests that mapping of the JSON objects are working.
 *
 * @author paul.wheeler
 */
public class JsonMappingTest {
    @Test
    public void testMapping() throws IOException {
        InputStream inputStream = this.getClass().getResourceAsStream(
                "/org/springframework/social/dailycred/api/testdata/profile.json");
        ObjectMapper mapper = new ObjectMapper();
        DailyCredProfile profile = mapper.readValue(inputStream, DailyCredProfile.class);
        assertJsonMappings(profile);
    }

    public static void assertJsonMappings(DailyCredProfile profile) {
        assertNotNull(profile);
        assertEquals(true, profile.isEmailVerified());
        assertEquals("c3681ad2-250a-4985-ae8a-fdad48123235", profile.getAccessTokens().get("dailycred"));
        assertEquals("ya31.AHES6ZTp2HijFmiz3EthqpOB5e6EqEje5_0eI25UB9Jn_MP0ERlGAg", profile.getAccessTokens().get("google"));
        assertEquals("AAADuiLHgPRcBEAplxD9I22dWzx9nW18KdvpDUdBRy8UqrdykTSJui8YPJMSF8rR2OKTzjod8kZBOXy939eTCOUOp26ONOrehFKPTYCQZDZD", profile.getAccessTokens().get("facebook"));
        assertEquals("44431966-TgD3VOLgxDv91bsHDDLtuEaupBVueaI512yLYLhjY", profile.getAccessTokens().get("twitter"));
        assertEquals(new Long(1348881437129L), profile.getUpdatedAt());
        assertEquals("a4babca4-1157-4314-b793-024b62093998", profile.getId());
        assertEquals("joesmith@dailycred.com", profile.getDisplay());
        assertEquals("jsmitty", profile.getUsername());
        assertEquals(false, profile.isGuest());
        assertEquals(new Long(1348873419043L), profile.getCreated());
        assertEquals("joesmith@dailycred.com", profile.getEmail());
    }
}
