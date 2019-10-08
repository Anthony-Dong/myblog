package com.blogs.web;


import com.blogs.service.DownLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


/**
 * ClassName:DownLoadController
 * Package:com.blogs.web
 * Description:TODO
 *
 * @date:2019/8/27 21:04
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

//@RestController
//@RequestMapping("upload")
public class DownLoadController {

//    @Autowired
    private DownLoadService service;

    @GetMapping("get/{id}")
    public ResponseEntity<HashMap<String, Object>> readProject(@PathVariable("id") String id) {
        return ResponseEntity.ok(service.getProject(id));
    }

    @GetMapping("get/file")
    public ResponseEntity<HashMap<String, Object>> readFile(@RequestParam("id") String id) {

        return ResponseEntity.ok(service.readFile(id));
    }

}
