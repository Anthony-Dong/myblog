package com.blogs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * ClassName:GatewayApplication
 * Package:com.blogs
 * Description:TODO
 *
 * @date:2019/8/23 18:15
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
