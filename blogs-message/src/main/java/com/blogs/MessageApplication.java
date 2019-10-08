package com.blogs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * ClassName:MessageApplication
 * Package:com.blogs
 * Description:TODO
 *
 * @date:2019/8/26 15:42
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

@EnableMongoRepositories("com.blogs.repository")
@EnableDiscoveryClient
@SpringBootApplication
public class MessageApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessageApplication.class, args);
    }
}
