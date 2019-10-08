package com.blogs.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blogs.common.exception.EnumException;
import com.blogs.common.exception.UtilException;
import com.blogs.pojo.Project;
import com.blogs.service.impl.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author anthony
 * @since 2019-08-25
 */
@Controller
@RequestMapping("/admin/project")
public class ProjectController {

    @Autowired
    private ProjectServiceImpl service;

    /**
     * 保存 表单
     * @param project
     * @return
     */
    @PostMapping("save")
    public ResponseEntity<String> saveProject(@RequestBody Project project) {

        return ResponseEntity.ok().body(service.saveProject(project));
    }


    /**
     * 查找全部表单
     * @param id
     * @return
     */
    @GetMapping("find/{id}")
    public ResponseEntity<List<Project>> findByCategoryId(@PathVariable("id") Integer id) {
        List<Project> list = service.findByCategoryId(id);
        if (ObjectUtils.isEmpty(list)) {
            throw new UtilException(EnumException.BAN_REQUEST);
        }
        return ResponseEntity.ok(list);
    }

    /**
     * 分页查询
     * @param id
     * @param page
     * @return
     */
    @GetMapping("find/{id}/{page}")
    public ResponseEntity<IPage<Project>>  findByCategoryIdPage(@PathVariable("id") Integer id, @PathVariable(value = "page") Long page) {
        IPage<Project> list = service.findByCategoryIdPage(id,page);
        if (ObjectUtils.isEmpty(list)) {
            throw new UtilException(EnumException.BAN_REQUEST);
        }
        return ResponseEntity.ok(list);
    }

    /**
     * 查看最近的文件
     * @return
     */
    @GetMapping("find/latest")
    public ResponseEntity<List<Project>> findSomeLatestProject(){

        return ResponseEntity.ok(service.findSomeLatestProject());
    }

    /**
     * 根据id 查找文件
     */
    @GetMapping("get/{id}")
    public ResponseEntity<Project> findByProjectId(@PathVariable("id") String id) {
        return ResponseEntity.ok(service.findByProjectId( id));
    }
}

