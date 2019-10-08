package com.blogs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * ClassName:UserInfo
 * Package:com.dubbo.auth.dto
 * Description:
 *      用户的登录校验表
 * @date:2019/8/11 21:13
 * @author: 574986060@qq.com
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo implements Serializable {

    private static final long serialVersionUID = -8875741470732536588L;
    private String id;
    private String username;
//    用户权限 我的权限是 1是超级管理员
//      0 是普通用户
    private Integer auth;
    private String ip;

}
