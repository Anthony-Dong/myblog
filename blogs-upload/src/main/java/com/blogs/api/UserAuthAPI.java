package com.blogs.api;

import com.blogs.dto.LoginUserInfo;
import com.blogs.pojo.Admin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * ClassName:UserAuthAPI
 * Package:com.blogs.api
 * Description:  用户登录接口
 *
 * @date:2019/8/24 11:40
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public interface UserAuthAPI {

    @PostMapping("admin/login")
    Admin findAdmin(@RequestBody LoginUserInfo info);


}
