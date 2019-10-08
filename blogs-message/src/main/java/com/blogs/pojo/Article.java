package com.blogs.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


/**
 * ClassName:Article
 * Package:com.blogs.pojo
 * Description:TODO
 *
 * @date:2019/8/28 22:17
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
@Data
@Document("article")
public class Article {

    @Id
    private String id;


    private String name;

    private List<String> list;
}
