package farcicDev.usersSemMq.infra.config.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

    //gera a chave baseada no segredo definido no application.properties
    private SecretKey getsecretKey() {
        return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    //Gera o token com o email e a role do usuário
    public String generateToken(String email, String role) {
        return Jwts.builder()
                .setSubject(email)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getsecretKey())
                .compact();
    }

    // Extrai tudo do token
    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getsecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    // Verifica se o token é válido (não expirado)
    public boolean isTokenValid(String token) {
        try {
            Date expirationDate = extractAllClaims(token).getExpiration();
            return expirationDate.after(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    // Extrai o email do token
    public String extractEmail(String token) {
        return extractAllClaims(token).getSubject();
    }

    // Extrai a role do token
    public String extractRole(String token) {
        return extractAllClaims(token).get("role", String.class);
    }



}
