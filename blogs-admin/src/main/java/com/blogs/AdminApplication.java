package com.blogs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * ClassName:AdminApplication
 * Package:com.blogs
 * Description:TODO
 *
 * @date:2019/8/23 18:46
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

@EnableMongoRepositories("com.blogs.repository")
@EnableDiscoveryClient
@SpringBootApplication
public class AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }
}
