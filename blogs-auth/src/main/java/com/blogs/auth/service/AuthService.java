package com.blogs.auth.service;


import com.blogs.auth.client.UserClient;
import com.blogs.auth.config.JwtProperties;
import com.blogs.auth.util.JwtUtils;
import com.blogs.common.exception.EnumException;
import com.blogs.common.exception.UtilException;
import com.blogs.common.util.UtilLog;
import com.blogs.dto.LoginUserInfo;
import com.blogs.dto.UserInfo;
import com.blogs.pojo.Admin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * ClassName:AuthService
 * Package:com.dubbo.auth.service
 * Description:
 *
 * @date:2019/8/11 22:16
 * @author: 574986060@qq.com
 */

@Service
@EnableConfigurationProperties(JwtProperties.class)
public class AuthService{

    @Autowired
    private UserClient UserClient;

    @Autowired
    private JwtProperties properties;


    public void verrify(String username, String password) {


    }

    public String login(LoginUserInfo info, String ipAddress) {

        try {
            Admin admin = UserClient.findAdmin(info);


            UserInfo userInfo = new UserInfo();

            userInfo.setAuth(admin.getAuth());
            userInfo.setUsername(admin.getName());

            userInfo.setIp(ipAddress);

            userInfo.setId(admin.getId());


            String token = JwtUtils.generateToken(userInfo, properties.getPrivateKey(), properties.getExpire());

            return token;
        } catch (Exception e) {
            UtilLog.error("授权中心",e,"用户密码 或者 账号错误 "+info.getUsername());
            throw new UtilException(EnumException.BAN_LOGIN);
        }

    }
}
