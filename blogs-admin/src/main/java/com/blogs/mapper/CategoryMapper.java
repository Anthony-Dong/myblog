package com.blogs.mapper;

import com.blogs.dto.CountProject;
import com.blogs.pojo.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author anthony
 * @since 2019-08-25
 */
public interface CategoryMapper extends BaseMapper<Category> {

    List<CountProject> selectCountProjectById();
}
