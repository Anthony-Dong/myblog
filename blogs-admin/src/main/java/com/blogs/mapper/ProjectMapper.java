package com.blogs.mapper;

import com.blogs.pojo.Project;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author anthony
 * @since 2019-08-25
 */
public interface ProjectMapper extends BaseMapper<Project> {


    List<Project> selectSomeLatestProject(@Param("start") Integer start, @Param("count") Integer count);
}
