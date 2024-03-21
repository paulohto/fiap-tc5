package com.fiap.tc5apicarts.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JwtDTO {

    private Long id;
    private String login;

    public static JwtDTO getUser(Claims jwtClaims) {
        try {
            return new ObjectMapper().convertValue(jwtClaims.get("authUser"), JwtDTO.class);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
