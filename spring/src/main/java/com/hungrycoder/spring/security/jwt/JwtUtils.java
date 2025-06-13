package com.hungrycoder.spring.security.jwt;

import java.security.Key; // Import Key for cryptographic operations
import java.util.Date; // Import Date for handling date and time

import org.slf4j.Logger; // Import Logger for logging errors and information
import org.slf4j.LoggerFactory; // Import LoggerFactory for creating Logger instances
import org.springframework.beans.factory.annotation.Value; // Import Value for dependency injection
import org.springframework.security.core.Authentication; // Import Authentication for handling user authentication
import org.springframework.stereotype.Component; // Import Component for Spring component scanning
import com.hungrycoder.spring.security.services.UserDetailsImpl; // Import custom user details implementation
import io.jsonwebtoken.*; // Import the JJWT library classes for handling JWT
import io.jsonwebtoken.io.Decoders; // Import Decoders for decoding JWT secret
import io.jsonwebtoken.security.Keys; // Import Keys for creating keys for JWT signing

/**
 * Utility class for managing JSON Web Tokens (JWT).
 */
@Component // Indicate that this class is a Spring component
public class JwtUtils {

  private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class); // Logger for logging errors

  @Value("${jwt.secret}")
  private String jwtSecret;


  @Value("${jwtExpirationMs}")
  private int jwtExpirationMs;

  public String generateJwtToken(Authentication authentication) {
    // Get the user details from the authentication object
    UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

    // Build and return the JWT token
    return Jwts.builder()
            .setSubject((userPrincipal.getUsername())) // Set the subject (username)
            .setIssuedAt(new Date()) // Set the issue date
            .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs)) // Set the expiration date
            .signWith(key(), SignatureAlgorithm.HS256)
            // Sign the token using the secret key and algorithm
            .compact(); // Compact the JWT into a string
  }


  private Key key() {
    // Decode the JWT secret and create a signing key
    return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
  }


  public String getUserNameFromJwtToken(String token) {
    // Parse the JWT token and return the subject (username)
    return Jwts.parserBuilder().setSigningKey(key()).build()
            .parseClaimsJws(token).getBody().getSubject();
  }


  public boolean validateJwtToken(String authToken) {
    try {
      // Parse the token and verify its signature
      Jwts.parserBuilder().setSigningKey(key()).build().parse(authToken);
      return true; // Token is valid
    } catch (MalformedJwtException e) {
      logger.error("Invalid JWT token: {}", e.getMessage()); // Log invalid token error
    } catch (ExpiredJwtException e) {
      logger.error("JWT token is expired: {}", e.getMessage()); // Log expired token error
    } catch (UnsupportedJwtException e) {
      logger.error("JWT token is unsupported: {}", e.getMessage()); // Log unsupported token error
    } catch (IllegalArgumentException e) {
      logger.error("JWT claims string is empty: {}", e.getMessage()); // Log empty claims error
    }

    return false; // Token is invalid
  }
}
