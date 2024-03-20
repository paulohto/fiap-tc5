package com.fiap.tc5apiproducts.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.fiap.tc5apiproducts.dto.JwtDTO;
import com.fiap.tc5apiproducts.exceptions.ResourceNotFoundException;
import com.fiap.tc5apiproducts.exceptions.ValidationException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.lang.Strings;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static com.auth0.jwt.JWT.require;
import static org.springframework.util.ObjectUtils.isEmpty;

@Service
public class JwtService {

    @Value("${app-config.secrets.api-secret}")
    private String jwtSecret;

    private static final String BEARER = "Bearer";

    public void validateAuthorization(String token){
        try {
            var accessToken = extractToken(token);
            var claims = Jwts
                    .parser()
                    .setSigningKey(Keys.hmacShaKeyFor(Algorithm.HMAC256(jwtSecret).getSigningKeyId().getBytes()))
                    .build()
                    .parseClaimsJws(accessToken)
                    .getBody();
            var user = JwtDTO.getUser(claims);
            if (isEmpty(user) || isEmpty(user.getId())) {
                throw new ResourceNotFoundException("The user is not valid.");
            }

        } catch (Exception e){
            e.printStackTrace();
            throw new ResourceNotFoundException("Erro ao validar token!");
        }
    }
    private String extractToken(String token){
        if(isEmpty(token)){
            throw new ValidationException("The access token was not informed.");
        }
        if (token.toLowerCase().contains(BEARER)){
            token = token.toLowerCase();

            return validateToken(token);
        }
        return token;
    }
    public String validateToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(jwtSecret);
            return require(algorithm)
                    .withIssuer("auth-api")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception){
            return "";
        }
    }
}
