package com.blogs.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * ClassName:FilterProperties
 * Package:com.leyou.properties
 * Description:
 *
 * @date:2019/7/21 18:39
 * @author: 574986060@qq.com
 */
@Data
@ConfigurationProperties(prefix = "myblogs.filter")
public class FilterProperties {
    private List<String> allowPaths;
    private List<String> notAllowPaths;
}
