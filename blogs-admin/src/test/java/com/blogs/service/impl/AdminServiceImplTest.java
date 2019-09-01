package com.blogs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.blogs.mapper.AdminMapper;
import com.blogs.mapper.ProjectMapper;
import com.blogs.pojo.Admin;
import com.blogs.pojo.Project;
import com.blogs.utils.Sha2Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminServiceImplTest {


    @Autowired
    private AdminMapper mapper;

    @Test
    public void  test(){
        Admin admin = mapper.selectOne(new LambdaQueryWrapper<Admin>().eq(Admin::getName, "dadong"));


        String salt = Sha2Util.generateSalt();
        String password = Sha2Util.generateKey("fanhaodong516", salt);

        mapper.update(admin, new UpdateWrapper<Admin>().lambda().set(Admin::getPassword, password)
                .set(Admin::getSalt, salt));
    }


    @Autowired
    private ProjectMapper projectMapper;


    @Test
    public void test02(){
        List<Project> list = projectMapper.selectSomeLatestProject(10, 5);


        list.forEach(System.out::println);
    }

}