package com.blogs.service;

import com.blogs.common.exception.EnumException;
import com.blogs.common.exception.UtilException;
import com.blogs.common.util.UtilLog;
import com.blogs.pojo.MPage;
import com.blogs.pojo.Message;
import com.blogs.pojo.User;
import com.blogs.repository.MessageRepository;
import com.blogs.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ClassName:MessageService
 * Package:com.blogs.service
 * Description:TODO
 *
 * @date:2019/8/26 15:58
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
@Slf4j
@Service
public class MessageService {

    @Autowired
    private MongoTemplate template;

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    public void saveMessage(String content, String type, String username, String ipAddress) {

        try {
            Message message = new Message();
            message.setContent(content);

            message.setCreateTime(new Date());

            message.setIsRead(1);

            message.setType(type);

            message.setIpAddress(ipAddress);

            message.setUsername(username);

            messageRepository.save(message);
        } catch (Exception e) {
            UtilLog.error("消息服务", e,content);
            throw new UtilException(EnumException.BAN_REQUEST);
        }

    }


    public void saveUser(User user) {

        try {
            userRepository.save(user);
        } catch (Exception e) {
            UtilLog.error("消息服务", e,user.getEmail());
            throw new UtilException(EnumException.BAN_REQUEST);
        }

    }





    public List<Message> getLatestMsg(String type,Integer size) {
        List<Message> messages = null;
        try {
            /**
             * 先查询 type 类型的全部消息
             */
            long count = getCount(type);

            if (count == 0) {
                UtilLog.info("消息服务", "查询不到信息");
                return null;
            }

            if (size > count) {
                size = Math.toIntExact(count);
            }
            // 然后根据 消息的种类  他这个会先排序
            Sort sort = new Sort(Sort.Direction.DESC,"createTime");

            Query limit = new Query(Criteria.where("type").is(type))
                    .skip(count - size).limit(size);

            messages = template.find(limit, Message.class).stream().sorted((m1,m2)-> m2.getCreateTime().compareTo(m1.getCreateTime())).collect(Collectors.toList());

        } catch (Exception e) {
            UtilLog.error("消息服务", e,"查询错误");
            return null;
        }
        return messages;
    }






    private long getCount(String type) {
        Query query = new Query(Criteria.where("type").is(type));
        return template.count(query, Message.class);
    }

    public MPage<Message> getPageOfMsg(String type, Integer page, Integer size) {

        long count = getCount(type);

        if (count == 0) {
            return null;
        }

        MPage<Message> messageMPage = null;
        try {
            Sort sort = new Sort(Sort.Direction.DESC,"createTime");

            PageRequest pageRequest = new PageRequest(page, size, sort);
            Query query = new Query().addCriteria(Criteria.where("type").is(type)).with(pageRequest);


            List<Message> messages = template.find(query, Message.class);

            messageMPage = new MPage<>(count, page, size, messages);
        } catch (Exception e) {
            log.error("[消息服务]   查询错误");
        }

        return messageMPage;
    }






}
