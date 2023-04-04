package com.yash.wall.security;

public interface SecurityConstants {
    public static final String REGISTER_PATH = "/user/register";
    public static final String JWT_SECRET = "1234567890";
    public static final String AUTHORIZATION = "authorization";
    public static final String AUTH_COOKIE = "AUTH_COOKIE";
    public static final String BEARER = "Bearer ";
    public static final int JWT_TOKEN_EXPIRATION_MS = 604800000;
    public static final String ALLOWED_ORIGIN = "http://localhost:3000";
}
