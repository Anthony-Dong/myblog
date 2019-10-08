package com.blogs.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * ClassName:AliyunossProperties
 * Package:com.aliyun.config
 * Description:
 *
 * @date:2019/8/17 17:02
 * @author: 574986060@qq.com
 */
@Data
@Component
public class AliyunossProperties {
    @Value("${aliyunoss.endpoint}")
    private String endpoint;
    @Value("${aliyunoss.accessKeyId}")
    private String accessKeyId;
    @Value("${aliyunoss.accessKeySecret}")
    private String accessKeySecret;
    @Value("${aliyunoss.bucketName}")
    private String bucketName;
    @Value("${aliyunoss.pathName}")
    private String pathName;
    @Value("${aliyunoss.imagePathName}")
    private String imagePathName;

    @Value("${aliyunoss.filePathName}")
    private String filePathName;
    @Value("${aliyunoss.avatorSize}")
    private Integer avatorSize;

    @Value("${aliyunoss.stylename}")
    private String stylename;

    @Value("${aliyunoss.imageSize}")
    private Integer imageSize;
    @Value("${aliyunoss.fileSize}")
    private Integer fileSize;

    /*private static String ENDPOINT;
    private static String ACCESSKEYID;
    private static String ACCESSKEYSECRET;
    private static String BUCKETNAME;
    @Override
    public void afterPropertiesSet() throws Exception {

        ENDPOINT = this.endpoint;

        ACCESSKEYID = this.accessKeyId;
    }*/
}
