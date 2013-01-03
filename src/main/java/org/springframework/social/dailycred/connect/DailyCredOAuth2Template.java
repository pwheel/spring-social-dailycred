package org.springframework.social.dailycred.connect;

import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.social.support.ClientHttpRequestFactorySelector;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * Pretty sure a custom {@link OAuth2Template} implementation is not needed for DailyCred integration. If it is,
 * it would be instantiated by the {@link DailyCredServiceProvider#DailyCredServiceProvider(String, String)}
 *
 * @author paul.wheeler
 */
public class DailyCredOAuth2Template extends OAuth2Template {

    private static final String DAILYCRED_AUTHORISATION_URL = "https://www.dailycred.com/connect";
    private static final String DAILYCRED_ACCESS_TOKEN_URL = "https://www.dailycred.com/oauth/access_token";

    public DailyCredOAuth2Template(String clientId, String clientSecret) {
        // TODO: Do we need a separate URL for authentication and authorise?
        super(clientId, clientSecret, DAILYCRED_AUTHORISATION_URL, DAILYCRED_ACCESS_TOKEN_URL);
        setUseParametersForClientAuthentication(true);
    }

    @Override
    protected RestTemplate createRestTemplate() {
        RestTemplate restTemplate = new RestTemplate(ClientHttpRequestFactorySelector.getRequestFactory());
//        FormHttpMessageConverter messageConverter = new FormHttpMessageConverter() {
//            public boolean canRead(Class<?> clazz, MediaType mediaType) {
//                // always read as x-www-url-formencoded even though Facebook sets contentType to text/plain
//                return true;
//            }
//        };
//        restTemplate.setMessageConverters(Collections.<HttpMessageConverter<?>>singletonList(messageConverter));
        return restTemplate;
    }

    @Override
    @SuppressWarnings("unchecked")
    protected AccessGrant postForAccessGrant(String accessTokenUrl, MultiValueMap<String, String> parameters) {
        MultiValueMap<String, String> response = getRestTemplate().postForObject(accessTokenUrl, parameters, MultiValueMap.class);
        // TODO: Remove?
        String expires = response.getFirst("expires");
        return new AccessGrant(response.getFirst("access_token"), null, null, expires != null ? Integer.valueOf(expires) : null);
    }
}
