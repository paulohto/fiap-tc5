package com.fiap.tc5apicarts.services;

import org.springframework.stereotype.Service;

@Service
public class JwtService {

    private String jwtSecret;

    public void validateAuthorization(String token){
//        try {
//            var claims = Jwts
//                    .parserBuilder()
//                    .setSigningKey(Keys.hmacShaKeyFor(apiSecret.getBytes()))
//                    .build()
//                    .parseClaimsJws(accessToken)
//                    .getBody();
//            var user = JwtDTO.getUser(claims);
//            if (isEmpty(user) || isEmpty(user.getId())) {
//                throw new ResourceNotFoundException("The user is not valid.");
//            }
//
//        } catch (Exception e){
//            e.printStackTrace();
//            throw new ResourceNotFoundException("Erro ao validar token!");
//        }
    }
}
