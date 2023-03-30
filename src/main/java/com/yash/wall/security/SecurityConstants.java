package com.yash.wall.security;

public interface SecurityConstants {
    public static final String REGISTER_PATH = "/user/register";
    public static final String JWT_SECRET = "1234567890";
    public static final String AUTHORIZATION = "Authorization";
    public static final String BEARER = "Bearer ";
    public static final int JWT_TOKEN_EXPIRATION_MS = 604800000;
}
