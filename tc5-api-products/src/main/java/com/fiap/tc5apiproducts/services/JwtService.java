package com.fiap.tc5apiproducts.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.fiap.tc5apiproducts.dto.JwtDTO;
import com.fiap.tc5apiproducts.exceptions.AuthenticationException;
import com.fiap.tc5apiproducts.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static org.springframework.util.ObjectUtils.isEmpty;

@Service
public class JwtService {

    @Value("${app-config.secrets.api-secret}")
    private String jwtSecret;

    private static final String EMPTY_SPACE = " ";
    private static final Integer TOKEN_INDEX = 1;

    public JwtDTO getAuthenticatedUser(String token) {
        try {
            var accessToken = extractToken(token);
            Algorithm algorithm = Algorithm.HMAC256(jwtSecret);

            var jwt =  JWT.require(algorithm)
                    .withIssuer("auth-api")
                    .build()
                    .verify(accessToken)
                    .getClaims();

            var id = Long.valueOf(String.valueOf(jwt.get("id")));
            var username = String.valueOf(jwt.get("username"));
            return new JwtDTO(id, username);

        } catch (Exception ex) {
            throw new AuthenticationException("Invalid token: " + ex.getMessage());
        }
    }
    public void validateToken(String token){
        try {
            var tk = extractToken(token);
            Algorithm algorithm = Algorithm.HMAC256(jwtSecret);

            var jwt =  JWT.require(algorithm)
                    .withIssuer("auth-api")
                    .build()
                    .verify(tk)
                    .getClaims();
            if (isEmpty(jwt.get("user")) || isEmpty(jwt.get("id"))) {
                throw new AuthenticationException("The user is not valid.");
            }
        } catch (JWTVerificationException exception){
            throw new AuthenticationException("Error while trying to proccess the Access Token.");
        }
    }
    private String extractToken(String token) {
        if (isEmpty(token)) {
            throw new ResourceNotFoundException("The access token was not informed.");
        }
        if (token.contains(EMPTY_SPACE)) {
            return token.split(EMPTY_SPACE)[TOKEN_INDEX];
        }
        return token;
    }
}
