package br.com.danielhessel.jobs_management.utils;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.UUID;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestUtils {
    
    public static String objectToJSON(Object obj) {
        try {
            final ObjectMapper objectMapper = new ObjectMapper();
            System.out.println(obj);
            return objectMapper.writeValueAsString(objectMapper);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String generateCompanyToken(UUID id, String secret) {
        Algorithm algorithm = Algorithm.HMAC256(secret);

        var expiresIn = Instant.now().plus(Duration.ofHours(2));

        var token = JWT.create().withIssuer("jobs_management")
            .withSubject(id.toString())
            .withClaim("roles", Arrays.asList("COMPANY"))
            .withExpiresAt(expiresIn)
            .sign(algorithm);
        
        return token;
    }

}
