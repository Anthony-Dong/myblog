package com.blogs.auth.web;

import com.blogs.auth.config.JwtProperties;
import com.blogs.auth.service.AuthService;
import com.blogs.auth.util.CookieUtils;
import com.blogs.auth.util.JwtUtils;
import com.blogs.common.exception.EnumException;
import com.blogs.common.exception.UtilException;
import com.blogs.common.ip.IpUtil;
import com.blogs.dto.LoginUserInfo;
import com.blogs.dto.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName:AuthController
 * Package:com.dubbo.auth.web
 * Description:
 *
 * @date:2019/8/12 23:22
 * @author: 574986060@qq.com
 */
@Slf4j
@RestController
@RequestMapping("auth")
@EnableConfigurationProperties(JwtProperties.class)
public class AuthController {

    @Autowired
    private AuthService authService;

    @Value("${blogs.cookie.loginName}")
    private  String COOKIE_NAME;

    @Value("${blogs.cookie.maxAge}")
    private String COOKIE_MAX_AGE;


    @Autowired
    private JwtProperties properties;
    /**
     * 登录 中心
     * @param info
     * @param request
     * @param response
     * @return
     */
    @PostMapping("login")
    public ResponseEntity<Void> login(@RequestBody LoginUserInfo info,
        HttpServletRequest request, HttpServletResponse response) {

        String token = authService.login(info, IpUtil.getIpAddress(request));

        CookieUtils.setCookie(request, response, COOKIE_NAME, token, Integer.parseInt(COOKIE_MAX_AGE));

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @GetMapping("verify")
    public ResponseEntity<UserInfo> verify(HttpServletRequest request, HttpServletResponse response) {

        try {
            Cookie[] cookies = request.getCookies();
            String tokens = "";
            for (Cookie cookie : cookies) {
                if (!cookie.getName().equals(COOKIE_NAME)) {
                    throw new UtilException(EnumException.BAN_REQUEST);
                }
                tokens = cookie.getValue();
            }
            UserInfo info = JwtUtils.getInfoFromToken(tokens, properties.getPublicKey());
            String newToken = JwtUtils.generateToken(info, properties.getPrivateKey(), properties.getExpire());
            CookieUtils.setCookie(request, response, COOKIE_NAME, newToken, Integer.parseInt(COOKIE_MAX_AGE), true);
            return ResponseEntity.ok(info);
        } catch (Exception e) {
            log.error("[授权中心] 用户没有cookie ");
            throw new UtilException(EnumException.BAN_REQUEST);
        }
    }

}
