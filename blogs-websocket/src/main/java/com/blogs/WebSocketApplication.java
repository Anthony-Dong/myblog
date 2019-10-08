package com.blogs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * ClassName:WebSocketApplication
 * Package:com.blogs
 * Description:TODO
 *
 * @date:2019/8/26 22:36
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
@EnableWebSocket
@SpringBootApplication
public class WebSocketApplication {


    public static void main(String[] args) {
        SpringApplication.run(WebSocketApplication.class, args);
    }

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

}
