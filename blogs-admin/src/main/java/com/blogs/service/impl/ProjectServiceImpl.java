package com.blogs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blogs.common.exception.EnumException;
import com.blogs.common.exception.UtilException;
import com.blogs.pojo.Project;
import com.blogs.mapper.ProjectMapper;
import com.blogs.service.IProjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author anthony
 * @since 2019-08-25
 */
@Slf4j
@Service
@EnableTransactionManagement
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements IProjectService {

    @Autowired
    private ProjectMapper mapper;

    /**
     * 插入文章数据
     * @param project
     * @return
     */
    @Transactional
    @Override
    public String saveProject(Project project) {

        try {
            project.setCreateTime(new Date());
            project.setModifyTime(new Date());
            mapper.insert(project);
            return project.getId();
        } catch (Exception e) {
            log.error("[我的文件服务]  插入异常  ");
            throw new UtilException(EnumException.BAN_REQUEST);
        }
    }

    /**
     * 传入参数 如果是0 则 返回全部信息
     * 如果是 其他 则根据 参数具体信息返回
     * @param id
     * @return
     */
    @Override
    public List<Project> findByCategoryId(Integer id) {


        if (id == 0) {
            List<Project> projects = mapper.selectList(new LambdaQueryWrapper<Project>());
            return projects;
        }

        List<Project> projects = mapper.selectList(new LambdaQueryWrapper<Project>().eq(Project::getCategory, id));
        return projects;
    }


    public IPage<Project>  findByCategoryIdPage(Integer id,Long current) {

        if (id == 0) {
            IPage<Project> projectIPage = mapper.selectPage(new Page<Project>(current, 10), new LambdaQueryWrapper<>());
            return projectIPage;
        }

        IPage<Project> projectIPage = mapper.selectPage(new Page<Project>(current, 10),new LambdaQueryWrapper<Project>().eq(Project::getCategory,id));

        return projectIPage;
    }


    public List<Project> findSomeLatestProject(){

        List<Project> list = null;
        try {
            Integer integer = mapper.selectCount(new QueryWrapper<>());

            list = mapper.selectSomeLatestProject(integer - 5, 5);
        } catch (Exception e) {
            log.error("[我的文件服务]  查找异常  ");
            throw new UtilException(EnumException.BAN_REQUEST);
        }

        return list;
    }

    @Override
    public Project findByProjectId(String id) {

        try {
            Project project = mapper.selectOne(new LambdaQueryWrapper<Project>().eq(Project::getId, id));
            return project;
        } catch (Exception e) {
            log.error("[我的文件服务]  查找异常  文件id:{}", id);
            throw new UtilException(EnumException.BAN_REQUEST);
        }
    }

}
