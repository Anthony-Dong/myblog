package com.blogs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.Set;
@Configuration
@EnableScheduling
public class ScheduledConfig {

    @Autowired
    private ContextRefresher contextRefresher;

    /**
     * 一天 fixedRate = 432000000L,
     * 2019/8/31 1:00:00
     * 2019/9/7 1:00:00
     * 每周  六 凌晨一点执行
     */
    @Scheduled(fixedRate = 432000000L)
    public void test(){
        System.out.println("开始自动更新服务");
        Set<String> keys = contextRefresher.refresh();
        if (!keys.isEmpty()) {
            System.out.println("自动更新成功"+keys);
        }
    }

    @Bean
    public TaskScheduler taskScheduler(){
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(10);
        taskScheduler.initialize();
        return taskScheduler;
    }
}
