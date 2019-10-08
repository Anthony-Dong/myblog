package com.blogs.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum  JwtConstant {
    JWT_KEY_ID ("id"),
    JWT_KEY_USER_NAME ("username"),
    JWT_KEY_USER_AUTH("userauth"),
    JWT_KEY_IP_ADDRESS("ipaddress")

    ;

    String constant;
}