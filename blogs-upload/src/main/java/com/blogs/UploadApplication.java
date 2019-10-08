package com.blogs;

import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * ClassName:UploadApplication
 * Package:com.aliyun
 * Description:
 *
 * @date:2019/8/17 16:27
 * @author: 574986060@qq.com
 */
//@EnableDiscoveryClient
//@EnableFeignClients
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class UploadApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(UploadApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}
