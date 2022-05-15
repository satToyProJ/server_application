package com.example.toy_1st_demo.jwt;

public interface JwtProperties {
    String SECRET = "토이플젝";
    int EXPIRATION_TIME = 864000000; // 10일(1/1000초)
    String TOKEN_PREFIX = "Bearer ";
    String HEADER_STRING = "Authorization";
}
