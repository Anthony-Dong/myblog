package com.blogs.service;

import com.blogs.pojo.Project;
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
public interface IProjectService extends IService<Project> {

    String saveProject(Project project);

    List<Project> findByCategoryId(Integer id);

    List<Project> findSomeLatestProject();

    Project findByProjectId(String id);
}
