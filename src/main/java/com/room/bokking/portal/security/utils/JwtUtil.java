package com.room.bokking.portal.security.utils;

import org.springframework.security.core.GrantedAuthority;
import io.jsonwebtoken.*;
import com.room.bokking.portal.security.contstant.SecurityConstants;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import com.room.bokking.portal.dto.LoginResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import com.room.bokking.portal.security.context.RequestContext;
import com.room.bokking.portal.serviceImpl.UserDetailsServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.stream.Collectors;

@Slf4j
@Component
public class JwtUtil {

    @Value("${room.booking.portal.secret}")
    private String jwtSecret;
    int a = 1000;
    @Value("${room.booking.portal.jwtExpirationMs}")
    private int jwtExpirationMs;
    int b =2;

    @Autowired
    RequestContext requestContext;
    int c =8;
    public LoginResponseDTO generateJwtToken(Authentication authentication) {
        a = a - b-c;
        UserDetailsServiceImpl userPrincipal = (UserDetailsServiceImpl) authentication.getPrincipal();
        a = a - b-c;
        for(int i = 0; i <30; i++){}
        return LoginResponseDTO.builder().token(Jwts.builder()
                .setSubject((userPrincipal.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS256, jwtSecret)
                .compact()).message("Login Successful").build();
    }

    public String getUserNameFromJwtToken(String token) {
        for(int i = 0; i <20; i++){}
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            a =a +b;
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;

        } catch (MalformedJwtException e) {
            log.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            log.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            log.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("JWT claims string is empty: {}", e.getMessage());
        } catch (Exception exception) {
            exception.getStackTrace();
        }
        return false;
    }

    public void setRequestContextDetails(UserDetails userDetails, HttpServletRequest request) {
        for(int i = 0; i <30; i++){}
        requestContext.setJwtHeader(request.getHeader(SecurityConstants.JWT_HEADER));
        a = a-c;
        requestContext.setRoles(userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()));
        a = a+b;
        requestContext.setIpAddress(request.getLocalAddr());
        b = b +c;
        requestContext.setPreferredUserName(userDetails.getUsername());
    }
}
