package com.blogs.config;

import com.aliyun.oss.common.utils.LogUtils;
import com.blogs.common.util.UtilLog;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

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
//@ConfigurationProperties(prefix ="aliyunoss")
public class AliyunossProperties {


    private String endpoint;


    private String accessKeyId;


    private String accessKeySecret;


    private String bucketName;

    // avatarPathName
    private String pathName;


    private String imagePathName;


    private String filePathName;


    private String stylename;


    private Integer avatorSize;




    private Integer imageSize;


    private Integer fileSize;


    @Value("${aliyunoss.path}")
    private String path;





    @PostConstruct
    public void get() throws IOException {

        UtilLog.info("上传服务","文件路径 - "+path);

        Properties properties = new Properties();
        properties.load(new FileInputStream(new File(path)));


        this.endpoint= properties.getProperty("aliyunoss.endpoint");
        this.accessKeyId = properties.getProperty("aliyunoss.accessKeyId");
        this.accessKeySecret = properties.getProperty("aliyunoss.accessKeySecret");
        this.bucketName = properties.getProperty("aliyunoss.bucketName");
        this.pathName = properties.getProperty("aliyunoss.avatarPathName");
        this.imagePathName = properties.getProperty("aliyunoss.imagePathName");
        this.filePathName = properties.getProperty("aliyunoss.filePathName");
        this.stylename = properties.getProperty("aliyunoss.stylename");
        this.avatorSize = Integer.parseInt(properties.getProperty("aliyunoss.avatorSize"));
        this.imageSize = Integer.parseInt(properties.getProperty("aliyunoss.imageSize"));
        this.fileSize = Integer.parseInt(properties.getProperty("aliyunoss.fileSize"));

        UtilLog.info("上传服务","endpoint - "+this.endpoint);
        UtilLog.info("上传服务","bucketName - "+this.bucketName);


        UtilLog.info("上传服务","加载配置文件完成");

    }

}
