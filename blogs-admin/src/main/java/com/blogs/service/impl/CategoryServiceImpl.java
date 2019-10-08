package com.blogs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.blogs.common.exception.EnumException;
import com.blogs.common.exception.UtilException;
import com.blogs.dto.CountProject;
import com.blogs.pojo.Category;
import com.blogs.mapper.CategoryMapper;
import com.blogs.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author anthony
 * @since 2019-08-25
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {
    @Autowired
    private CategoryMapper mapper;

    @Override
    public List<Category> findIsParentList() {

        LambdaQueryWrapper<Category> wrapper = new LambdaQueryWrapper<>();

        wrapper.eq(Category::getIsParent, 1);

        List<Category> categories = mapper.selectList(wrapper);

        if (CollectionUtils.isEmpty(categories)) {

            throw new UtilException(EnumException.BAN_REQUEST);
        }
        return categories;
    }

    @Override
    public List<CountProject> findCountProjectById() {

        List<CountProject> countProjects = mapper.selectCountProjectById();

        if (ObjectUtils.isEmpty(countProjects)) {

            throw new UtilException(EnumException.BAN_REQUEST);
        }

        return countProjects;

    }
}
