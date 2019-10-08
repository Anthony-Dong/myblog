package com.blogs.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * ClassName:BaiduYun
 * Package:com.blogs.pojo
 * Description:TODO
 *
 * @date:2019/8/28 19:25
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
@Document("baidu")
@Data
public class BaiduYun {

    @Id
    private String id;

    private String title;

    private String desc;

    private String url;

    private String password;

    private Date createTime;
}
