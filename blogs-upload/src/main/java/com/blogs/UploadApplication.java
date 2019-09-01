package com.blogs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * ClassName:UploadApplication
 * Package:com.aliyun
 * Description:
 *
 * @date:2019/8/17 16:27
 * @author: 574986060@qq.com
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class UploadApplication {

    public static void main(String[] args) {
        SpringApplication.run(UploadApplication.class);
    }
}
