package com.blogs.service;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.blogs.dto.CountProject;
import com.blogs.pojo.Category;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author anthony
 * @since 2019-08-25
 */
public interface ICategoryService extends IService<Category> {



        List<Category> findIsParentList();

     List<CountProject> findCountProjectById();
}
