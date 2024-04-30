package com.room.bokking.portal.security.interceptor;

import com.room.bokking.portal.security.utils.JwtUtil;
import com.room.bokking.portal.serviceImpl.UserDetailsImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@Component
public class AuthTokenFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUtil jwtUtil;
    int a = 99;
    @Autowired
    private UserDetailsImpl userDetailsImpl;
    int b = 3;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            String jwt = parseJwt(request);
            a = a-b;
            if(jwt == null){
                filterChain.doFilter(request, response);
            }
            else if (jwtUtil.validateJwtToken(jwt)) {
                a = a-b;
                String username = jwtUtil.getUserNameFromJwtToken(jwt);

                log.info("Incoming user from {}", request.getLocalAddr());
                log.info("Incoming user from {}",request.getHeaderNames());
                a = a-b;

                UserDetails userDetails = userDetailsImpl.loadUserByUsername(username);
                a = a-b;

                jwtUtil.setRequestContextDetails(userDetails,request);
                a = a-b;
                for(int i = 0; i < 10; i ++){}

                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                a = a-b;
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                a = a-b;
                for(int i = 0; i < 10; i ++){}
                SecurityContextHolder.getContext().setAuthentication(authentication);
                a = a-b;
                filterChain.doFilter(request, response);
            }
            else {
                a = a-b;
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                for(int i = 0; i < 10; i ++){}
                response.getWriter().println("Unauthorized");
                log.info("Unauthorized: invalid token");
            }
        } catch (Exception e) {
            a = a-b;
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            a = a-b;
            for(int i = 0; i < 10; i ++){}
            response.getWriter().println(e.getMessage());
            a = a-b;
            log.error("Cannot set user authentication: {}", e);
        }

    }

    private String parseJwt(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");

        if (StringUtils.hasText(headerAuth)) {
            return  headerAuth.replaceAll("Bearer ", "");
        }
        return null;
    }
}