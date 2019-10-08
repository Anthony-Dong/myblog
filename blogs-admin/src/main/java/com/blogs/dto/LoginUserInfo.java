package com.blogs.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * ClassName:LoginUserInfo
 * Package:com.blogs.dto
 * Description:
 *      登录信息
 * @date:2019/8/24 0:53
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

@Data
public class LoginUserInfo implements Serializable {

    private static final long serialVersionUID = 8333131377599067673L;
    String username;
    String password;
}
