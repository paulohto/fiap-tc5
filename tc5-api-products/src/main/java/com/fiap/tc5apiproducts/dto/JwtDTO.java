package com.fiap.tc5apiproducts.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import jakarta.persistence.OneToOne;

public class JwtDTO {

    private Long id;
    private String login;
    private String password;

    public static JwtDTO getUser(Claims jwtClaims) {
        try {
            return new ObjectMapper().convertValue(jwtClaims.get("authUser"), JwtDTO.class);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
