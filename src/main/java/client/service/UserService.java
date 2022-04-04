package client.service;

import client.pojo.User;
import client.pojo.UserResponse;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.nio.charset.StandardCharsets;


@Service
public class UserService {
    private final RestTemplate restTemplate;
    @Value("${user.service.url}")
    private String userURL;

    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Iterable<UserResponse> getAllUsers(User user) {
        try {
            ResponseEntity<Iterable<UserResponse>> response = restTemplate.exchange(userURL, HttpMethod.GET,
                    new HttpEntity<>(createHeaders(user.getUsername(), user.getPassword())),
                    new ParameterizedTypeReference<>() {});
            return response.getBody();
        } catch (HttpClientErrorException e) {
            throw new ResponseStatusException(e.getStatusCode());
        }

    }

    private HttpHeaders createHeaders(String username, String password) {
        return new HttpHeaders() {{
            String auth = username + ":" + password;
            byte[] encodedAuth = Base64.encodeBase64(
                    auth.getBytes(StandardCharsets.US_ASCII));
            String authHeader = "Basic " + new String(encodedAuth);
            set("Authorization", authHeader);
        }};
    }
}
