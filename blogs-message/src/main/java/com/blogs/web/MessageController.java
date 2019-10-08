package com.blogs.web;

import com.blogs.common.ip.IpUtil;
import com.blogs.dto.MessageDto;
import com.blogs.pojo.MPage;
import com.blogs.pojo.Message;
import com.blogs.pojo.User;
import com.blogs.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * ClassName:Messagecontroller
 * Package:com.blogs.web
 * Description:TODO
 *
 * @date:2019/8/26 16:05
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
//@CrossOrigin
@RestController
@RequestMapping("message")
public class MessageController {

    @Autowired
    private MessageService service;

    /**
     * 保存会话 返回一个 201状态码
     * @param dto
     * @param request
     * @return
     */
    @PutMapping("send")
    public ResponseEntity<Void> saveMessage(@RequestBody MessageDto dto,
                                            HttpServletRequest request) {
        String ipAddress = IpUtil.getIpAddress(request);

        if (ObjectUtils.isEmpty(dto)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        if (ObjectUtils.isEmpty(dto.getContent())||dto.getContent().equals("")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        service.saveMessage(dto.getContent(), dto.getType(), dto.getUsername(), ipAddress);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     *      保存用户
     * @param user
     * @return   201代表保存成功
     */
    @PostMapping("saveUser")
    public ResponseEntity<Void> saveMessage(@RequestBody User user) {


        service.saveUser(user);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 查询消息记录  是按照 时间的 最新的在最前面排序的
     * @param page   起始页数 是 0
     * @param size
     * @return
     */
    @GetMapping("getMsg/{type}/{page}/{size}")
    public ResponseEntity<MPage<Message>> getPageOfMsg(
            @PathVariable("type") String type,
            @PathVariable("page") Integer page,
            @PathVariable("size") Integer size) {


        return ResponseEntity.ok(service.getPageOfMsg(type, page, size));
    }

    /**
     * 查询消息记录
     *
     * @return
     */
    @GetMapping("getLatest/{type}/{size}")
    public ResponseEntity<List<Message>> getMsg(@PathVariable("type") String type,
                                                @PathVariable("size")Integer size) {


        return ResponseEntity.ok(service.getLatestMsg(type,size));
    }

}
