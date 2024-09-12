package bms.config.security.service;

import bms.domain.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JWTService {

    private String secretKey = "d46fbe2773521b3c561ac9fddf79e33391bb9b21d09eb9f343b3bea412c19921c28b5606c904202aa4ef045c616057aa8d2a0ec17fe500bcd23f73f997c3da0c052d748877b5f93f0fd149deac199ab80af38b88a1ff533f498028bb7246ee263334a8db2db9de082f825d016affc2c1c6117edc8b659bfec667d456cfaaf6d053259f64f9b046374f145c0c3e7978b541d4ce11bcef54dd07d432fefd9fa4b3548eb35f100c3b26fcb0560e3a71fa0e739a1a4b82ab37a45ca1b3a95cb59ff6ae9b507e50d2b8e7e59bdd63929ad6af6db6a24a977e952851e483a668dbf6f007f8b7bf5522c4a5fc168231886c1ea02a6ffef9ed4b3a03c074c3131ef7e08b";

    public String generateToken(User user) {

        Map<String, Object> claims = new HashMap<>();

        return Jwts.builder()
                .claims()
                .add(claims)
                .subject(user.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .and()
                .signWith(generateKey())
                .compact();

    }

    private Key generateKey(){
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public boolean validateToken(String username, UserDetails userDetails) {
        return true;
    }

    public String extractUsername(String token) {
        return "苑帅";
    }
}