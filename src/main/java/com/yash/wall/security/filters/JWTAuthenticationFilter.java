package com.yash.wall.security.filters;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.yash.wall.security.SecurityConstants;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter {

    private Optional<String> getAuthCookie(Cookie[] cookies) {
        if (cookies == null)
            return Optional.empty();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(SecurityConstants.AUTH_COOKIE))
                return Optional.ofNullable(cookie.getValue());
        }
        return Optional.empty();
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // String header = request.getHeader(SecurityConstants.AUTHORIZATION);
        Cookie[] cookies = request.getCookies();
        Optional<String> authCookie = getAuthCookie(cookies);

        if (!authCookie.isPresent()) {
            filterChain.doFilter(request, response);
            return;
        }

        // if (header == null || !header.startsWith(SecurityConstants.BEARER)) {
        // filterChain.doFilter(request, response);
        // return;
        // }
        String token = authCookie.get().trim();
        // String token = header.replace(SecurityConstants.BEARER, "").trim();

        String email = JWT.require(Algorithm.HMAC512(SecurityConstants.JWT_SECRET))
                .build()
                .verify(token)
                .getSubject();
        Authentication authentication = new UsernamePasswordAuthenticationToken(email, null, Arrays.asList());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);

    }
}
