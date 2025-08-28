package com.example.springbootdemo.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {
    private final static String SECRET_KEY_STRING = "aeQ8ugNatJzMN0GgBymyi5aUMsQLclQx";
    private final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(SECRET_KEY_STRING.getBytes());

    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .subject(userDetails.getUsername())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(SECRET_KEY, Jwts.SIG.HS256)
                .compact();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        return extractUsername(token).equals(userDetails.getUsername());
    }

    // for extract the username form the encrypted token
    public String extractUsername(String token) {
        return Jwts.parser()    // return JwtParserBuilder object for decrypted the values in the token
                .verifyWith(SECRET_KEY) // give our SECRET_KEY
                .build()    // here we have JwtParserBuilder object
                .parseSignedClaims(token)   // here decrypted happens
                .getPayload()   // get all the decrypted data
                .getSubject();  // get the subject only
    }
}
