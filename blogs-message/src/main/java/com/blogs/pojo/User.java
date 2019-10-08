package com.blogs.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * ClassName:User
 * Package:com.blogs.pojo
 * Description:用户表
 *
 * @date:2019/8/26 15:47
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
@Data
@Document("users")
public class User implements Serializable {


    private static final long serialVersionUID = -4062904045435368517L;
    @Id
    private String id;

    /**
     * 用户名
     */
    private String username;


    /**
     * 用户email
     */
    private String email;


    /**
     *  是否订阅
     */
    private Integer isSign;
}
