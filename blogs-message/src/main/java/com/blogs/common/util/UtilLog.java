package com.blogs.common.util;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * ClassName:UtilLog
 * Package:com.blogs.com.blogs.common.util
 * Description:TODO
 *
 * @date:2019/8/28 13:30
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
@Slf4j
public class UtilLog {

    public static void error(String server,Exception e,String msg) {

        log.error("["+server+"] 时间:{}  异常信息:{}  错误信息:{}",
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")), e.getMessage(),msg);
    }

    public static void info(String server,String msg) {

        log.info("["+server+"] 时间:{}  提示信息:{}",
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh-mm-ss")), msg);
    }

    public static void warn(String server,String msg) {

        log.warn("["+server+"] 时间:{}  警告信息:{}",
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh-mm-ss")), msg);
    }
}
