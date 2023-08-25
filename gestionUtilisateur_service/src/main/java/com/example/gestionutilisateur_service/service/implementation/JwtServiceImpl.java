package com.example.gestionutilisateur_service.service.implementation;

import com.example.gestionutilisateur_service.entities.UserCredential;
import com.example.gestionutilisateur_service.service.JwtService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Service
@RequiredArgsConstructor
public class JwtServiceImpl implements JwtService {
    private static final String secret = "BvPHGM8C0ia4uOuxxqPD5DTbWC9F9TWvPStp3pb7ARo0oK2mJ3pd3YG4lxA9i8bj6OTbadwezxgeEByY";

    public void validateToken(final String token) {
        Jwts.parserBuilder().setSigningKey(getSignKey())
                .build().parseClaimsJws(token);
    }

    @Override
    public String generateToken(UserCredential userDetails, List<String> roles) {
        return createToken(userDetails, roles);
    }

    public String createToken(UserCredential userDetails, List<String> roles) {
        Map<String, Object> claims = Jwts.claims().setSubject(userDetails.getUsername());

        claims.put("roles", roles);
        claims.put("id", userDetails.getId());
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
    }

    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
