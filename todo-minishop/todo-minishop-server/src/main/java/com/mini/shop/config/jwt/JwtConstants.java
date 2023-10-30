package com.mini.shop.config.jwt;

public class JwtConstants {
    // Expiration Time
    public static final long MINUTE = 1000 * 60;
    public static final long HOUR = 60 * MINUTE;
    public static final long DAY = 24 * HOUR;
    public static final long MONTH = 30 * DAY;

    public static final long AT_EXP_TIME =  60 * MINUTE;
    public static final long RT_EXP_TIME =  120 * MINUTE;

    // Secret
    public static final String JWT_SECRET = "jwt_secret_key_hunseong_secret_key_jwt";

    // Header
    public static final String AT_HEADER = "access_token";
    public static final String RT_HEADER = "refresh_token";
    public static final String TOKEN_HEADER_PREFIX = "Bearer ";
}
