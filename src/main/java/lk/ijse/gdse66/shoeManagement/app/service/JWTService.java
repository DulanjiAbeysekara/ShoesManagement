package lk.ijse.gdse66.shoeManagement.app.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JWTService {
    String generateToken(UserDetails userDetail);
    String extractUsername(String token);
    boolean isTokenValid(String token, UserDetails userDetails);
}
