package com.blogs.service;

import com.blogs.dto.LoginUserInfo;
import com.blogs.dto.UserInfo;
import com.blogs.pojo.Admin;
import com.baomidou.mybatisplus.extension.service.IService;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author anthony
 * @since 2019-08-23
 */
public interface IAdminService extends IService<Admin> {

    Admin findAdmin(String id);

    List<Admin> find();

    Admin userLogin(LoginUserInfo info);
}
