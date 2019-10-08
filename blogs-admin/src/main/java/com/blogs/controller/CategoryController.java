package com.blogs.controller;


import com.blogs.dto.CountProject;
import com.blogs.pojo.Category;
import com.blogs.service.ICategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *  分类查询
 * @author anthony
 * @since 2019-08-25
 */

@Controller
@RequestMapping("/admin/category")
public class CategoryController {


    @Autowired
    private ICategoryService service;

    /**
     * 查询分类  查询一级分类
     * @return
     */

    @GetMapping("find")
    public ResponseEntity<List<Category>> findParent(){

        return ResponseEntity.ok(service.findIsParentList());
    }
    /**
     * 查询分类的数量
     * @return
     */
    @GetMapping("find/count")
    public  ResponseEntity<List<CountProject>> findCountProjectById(){

        return ResponseEntity.ok(service.findCountProjectById());
    }


}

