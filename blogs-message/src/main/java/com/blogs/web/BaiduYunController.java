package com.blogs.web;

import com.blogs.dto.BaiduDto;
import com.blogs.pojo.BaiduYun;
import com.blogs.service.BaiduYunService;
import com.mongodb.client.result.DeleteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName:BaiduYunService
 * Package:com.blogs.web
 * Description: 消息服务
 *
 * @date:2019/8/28 19:36
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
@RestController
@RequestMapping("message")
public class BaiduYunController {

    @Autowired
    private BaiduYunService service;

    @GetMapping("baidu/get")
    public ResponseEntity<List<BaiduYun>> getBaiduYun(){



        return ResponseEntity.ok().body(service.get());
    }


    @PostMapping("baidu/save")
    public ResponseEntity<String> saveBaiduYun(@RequestBody BaiduDto baiduYun) {

        return ResponseEntity.ok().body(service.saveBaidu(baiduYun));
    }


    @DeleteMapping("baidu/delete")
    public ResponseEntity<DeleteResult> deleteBaiduYun(@RequestParam("url") String url) {

        return ResponseEntity.ok().body(service.delete(url));
    }

}
