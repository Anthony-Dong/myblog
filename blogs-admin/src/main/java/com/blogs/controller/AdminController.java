package com.blogs.controller;


import com.blogs.common.exception.EnumException;
import com.blogs.common.exception.UtilException;
import com.blogs.common.ip.IpUtil;
import com.blogs.common.util.JwtUtils;
import com.blogs.common.util.UtilLog;
import com.blogs.config.JwtProperties;
import com.blogs.dto.LoginUserInfo;
import com.blogs.dto.UserInfo;
import com.blogs.pojo.Admin;
import com.blogs.service.IAdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * <p>
 *  前端控制器
 *
 *      这里是 token  ----
 *
 *
 *
 *
 * </p>
 *
 * @author anthony
 * @since 2019-08-23
 */
@Controller
@RequestMapping("/admin")
@EnableConfigurationProperties(JwtProperties.class)
public class AdminController {

    @Autowired
    private IAdminService service;

    @Autowired
    private JwtProperties properties;

//    @Value("${token.headerName}")
    private static final String headerName="Authorization";

    /**
     * 查询我的个人信息
     * @param id
     * @return
     */

    @GetMapping("find/{id}")
    public ResponseEntity<Admin> findAdmin(@PathVariable("id") String id) {

        return ResponseEntity.ok(service.findAdmin(id));
    }


    //
    @GetMapping("verify")
    public ResponseEntity< HashMap<String, Object>> findAdmin(HttpServletRequest request, HttpServletResponse response) {
        String header = request.getHeader(headerName);
        UserInfo userInfo = null;
        try {
            userInfo = JwtUtils.getInfoFromToken(header, properties.getPublicKey());
        } catch (Exception e) {
            return null;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("isOk", true);
        hashMap.put("userInfo", userInfo);
        return ResponseEntity.ok(hashMap);
    }


    /**
     * 提供接口  登录查询 ,传给 auth中心
     * @param info
     * @return
     */

    @PostMapping("login")
    public ResponseEntity<UserInfo> QueryAdmin(@RequestBody LoginUserInfo info, HttpServletRequest request,HttpServletResponse response) {
        Admin admin = service.userLogin(info);
        if (ObjectUtils.isEmpty(admin)) {
            throw new UtilException(EnumException.BAN_REQUEST);
        }
        String ipAddress = IpUtil.getIpAddress(request);
        UserInfo userInfo = new UserInfo();
        userInfo.setAuth(admin.getAuth());
        userInfo.setUsername(admin.getName());
        userInfo.setIp(ipAddress);

        userInfo.setId(admin.getId());

        String token = "";
        try {
            token = JwtUtils.generateToken(userInfo, properties.getPrivateKey(), properties.getExpire());
        } catch (Exception e) {
            UtilLog.error("登录中心",e,"生成token失败");
        }
        response.setHeader(headerName,token);

        return ResponseEntity.ok(userInfo);
    }


}

