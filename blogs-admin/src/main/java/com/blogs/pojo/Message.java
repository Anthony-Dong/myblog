package com.blogs.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * ClassName:Message
 * Package:com.blogs.pojo
 * Description:  评论区
 *
 * @date:2019/8/26 15:44
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
@Data
@Document("message")
public class Message implements Serializable {

    private static final long serialVersionUID = 6872590382787590934L;
    @Id
    private String id;


    /**
     * 消息内容
     */
    private String content;


    /**
     * 消息创建时间
     */
    private Date createTime;


    /**
     * 消息是否可读  如果 用户删除了 则为0
     *  可读为  1
     */
    private Integer isRead;
    /**
     * 0 代表是 无类别的,
     * 其他代表 每个 project的 值是 project id
     */
    private String type;


    /**
     * 用户的 ip
     */
    private String ipAddress;


    /**
     * 如果有 用户名   则写 ,否则不写
     * 可有可无
     *
     */
    private String username;


}
