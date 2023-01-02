package com.setec.mvc.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class TokenUtils {

    private final static String ACCESS_TOKEN_SECRET="ahHJhVGv6u8sFSGS5vsvs6SHS6SVSAsbds54sus7RSStsvd5DB7dvdjsts28";
    private final static Long ACCESS_TOKEN_VALIDITY_SECONDS=2_592_000L;

    public static String createToken(String nombre, String email, Collection<GrantedAuthority> authorities){
        long expirationTime =ACCESS_TOKEN_VALIDITY_SECONDS*1_000;
        Date expirationDate = new Date(System.currentTimeMillis()+expirationTime);

        Map<String, Object> extra = new HashMap<>();
        extra.put("nombre",nombre);
        extra.put("authorities",authorities);
        return Jwts.builder()
                .setSubject(email)
                .setExpiration(expirationDate)
                .addClaims(extra)
                .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
                .compact();
    }

    public static UsernamePasswordAuthenticationToken getAuthentication(String token){
        try{
                Claims claims = Jwts.parserBuilder()
                        .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
                        .build()
                        .parseClaimsJws(token)
                        .getBody();

                String email= claims.getSubject();
            List<GrantedAuthority> authorities=(List<GrantedAuthority>)claims.get("authorities");

                return new UsernamePasswordAuthenticationToken(email,null, authorities);
        }catch (JwtException e){
            return null;
        }
    }
}
