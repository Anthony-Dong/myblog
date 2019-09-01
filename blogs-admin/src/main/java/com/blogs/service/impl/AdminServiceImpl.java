package com.blogs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.blogs.dto.LoginUserInfo;

import com.blogs.pojo.Admin;
import com.blogs.mapper.AdminMapper;
import com.blogs.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blogs.common.exception.EnumException;
import com.blogs.common.exception.UtilException;
import com.blogs.utils.Sha2Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;


import java.util.List;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author anthony
 * @since 2019-08-23
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

    @Autowired
    private AdminMapper mapper;


    @Override
    public List<Admin> find(){
       return mapper.selectList(new LambdaQueryWrapper<>());
    }


    /**
     * 登录校验
     * @param info
     * @return
     */
    @Override
    public Admin userLogin(LoginUserInfo info) {
        String username = info.getUsername();
        String password = info.getPassword();

        if (ObjectUtils.isEmpty(username)||ObjectUtils.isEmpty(password)) {
            throw new UtilException(EnumException.BAN_REQUEST);
        }


        Admin admin = mapper.selectOne(new LambdaQueryWrapper<Admin>().eq(Admin::getName, username));


        if (ObjectUtils.isEmpty(admin)) {
            throw new UtilException(EnumException.BAN_LOGIN_USERNAME);
        }


        String pass=admin.getPassword();

        String salt=admin.getSalt();


//      账户输入的密码+账户的盐值 =  账户真实密码
        String newpass = Sha2Util.generateKey(password, salt);


        if (!newpass.equals(pass)) {
            throw new UtilException(EnumException.BAN_LOGIN_PASSWORD);
        }


        return  admin;
    }

    /**
     * 查询我的信息
     * @param id
     * @return
     */
    @Override
    public Admin findAdmin(String id) {
        if (ObjectUtils.isEmpty(id)) {
            throw new UtilException(EnumException.BAN_REQUEST);
        }


        if (!id.equals("1")) {
            throw new UtilException(EnumException.BAN_REQUEST);
        }

        LambdaQueryWrapper<Admin> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Admin::getId, id);

        Admin admin = mapper.selectOne(wrapper);
        if (ObjectUtils.isEmpty(admin)) {
            throw new UtilException(EnumException.BAN_FIND);
        }

        return admin;
    }
}
