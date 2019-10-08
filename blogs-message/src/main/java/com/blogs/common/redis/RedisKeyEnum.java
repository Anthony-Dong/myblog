package com.blogs.common.redis;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ClassName:RedisKeyEnum
 * Package:com.blogs.com.blogs.common.redis
 * Description:
 *
 * @date:2019/8/11 23:39
 * @author: 574986060@qq.com
 */
@AllArgsConstructor
@Getter
public enum RedisKeyEnum {

    USER_SALT_KEY("user_salt_key"),
    USER_IP_KEY("user_ip_key"),

    /**
     * 后面跟手机号后三位
     */
    USER_Phone_KEY ("user_phone_"),
//    用户信息表
    USER_INFO_KEY("user_info_key"),
//    用户信息表的 hash的 key+username
    USER_INFO_USERNAME_KEY("user_info_username_"),
//    校验验证码用的
    USER_VERIFY_CODE("user_verify_phone_"),
    ;

    String key;

}
