package com.blogs.config;

import com.blogs.uitl.RsaUtils;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.PostConstruct;
import java.security.PublicKey;

/**
 * ClassName:JwtProperties
 * Package:com.leyou.properties
 * Description:
 *
 * @date:2019/7/21 18:31
 * @author: 574986060@qq.com
 */
@Data
@Slf4j
@ConfigurationProperties(prefix = "myblogs.jwt")
public class JwtProperties {
    private String pubKeyPath;
    private String cookieName;
    private PublicKey publicKey;

    @PostConstruct
    public void init(){
        try {
           this.publicKey = RsaUtils.getPublicKey(pubKeyPath);
        } catch (Exception e) {
            log.error("初始化公钥和私钥失败！", e);
            throw new RuntimeException();
        }
    }
}
