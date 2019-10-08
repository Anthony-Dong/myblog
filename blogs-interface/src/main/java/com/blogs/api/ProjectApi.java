package com.blogs.api;

import com.blogs.pojo.Project;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * ClassName:PoojectApi
 * Package:com.blogs.api
 * Description:TODO
 *
 * @date:2019/8/27 21:59
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public interface ProjectApi {

    /**  这里 的路径 不用考虑网关的那个  我傻逼了
     * 根据文件id
     * @param id
     * @return
     */
    @GetMapping("project/get/{id}")
    Project findByProjectId(@PathVariable("id") String id);

    /**
     * 根据分类 查询  0是全部 其他事么个
     * @param id
     * @return
     */
    @GetMapping("project/find/{id}")
    List<Project> findByCategoryId(@PathVariable("id") Integer id);
}
