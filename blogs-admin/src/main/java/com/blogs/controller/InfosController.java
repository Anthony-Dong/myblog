package com.blogs.controller;


import com.blogs.pojo.Infos;
import com.blogs.service.IInfosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 *  其他信息服务接口
 * </p>
 *
 * @author anthony
 * @since 2019-08-25
 */

@Controller
@RequestMapping("/infos")
public class InfosController {

    @Autowired
    private IInfosService service;

    /**
     * 查看其他信息通过名称
     * @param name
     * @return
     */
    @GetMapping("find")
    public ResponseEntity<Infos> getInfoByName(@RequestParam("name") String name) {


        return ResponseEntity.ok(service.findInfoByName(name));

    }
}

