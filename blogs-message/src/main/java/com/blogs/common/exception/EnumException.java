package com.blogs.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * ClassName:EnumException
 * Package:com.blogs.com.blogs.common.exception
 * Description:
 *
 * @date:2019/8/11 22:58
 * @author: 574986060@qq.com
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum EnumException {

    BAN_REGISTER_OPERATION(HttpStatus.BAD_REQUEST, "注册失败,请重试"),
    BAN_REGISTER_USERNAME(HttpStatus.BAD_REQUEST, "注册失败,用户名已存在"),
    BAN_LOGIN_USERNAME(HttpStatus.BAD_REQUEST, "登陆失败,用户名不存在"),
    BAN_LOGIN_PASSWORD(HttpStatus.BAD_REQUEST, "登陆失败,密码错误"),
    SYSTEM_INTERNAL_BAD(HttpStatus.BAD_REQUEST, "系统内部错误"),
    BAN_REQUEST(HttpStatus.BAD_REQUEST, "错误的请求,请重新尝试"),
    BAN_FIND(HttpStatus.BAD_REQUEST, "查询失败,请重新尝试"),
    BAN_LOGIN(HttpStatus.BAD_REQUEST, "账户名或者密码错误"),


;
    HttpStatus status;
    String msg;
}
