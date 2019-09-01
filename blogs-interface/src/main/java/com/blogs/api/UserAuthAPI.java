package com.blogs.api;

import com.blogs.dto.LoginUserInfo;
import com.blogs.dto.UserInfo;

import com.blogs.pojo.Admin;
import com.blogs.pojo.Project;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

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
