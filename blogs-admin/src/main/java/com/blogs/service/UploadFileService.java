package com.blogs.service;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.blogs.config.AliyunossProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.UUID;

/**
 * ClassName:UploadFileService
 * Package:com.blogs.service
 * Description:TODO
 *
 * @date:2019/8/25 0:05
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
@Slf4j
@Service
public class UploadFileService {




    @Autowired
    private AliyunossProperties properties;


    public String uploadFile(MultipartFile file) {


        if (file.getSize()>properties.getFileSize()){
            log.error("[文件服务]  上传失败 文件太大 ");
            throw new RuntimeException("文件太大");
        }


        //文件名 后缀
        String oname = file.getOriginalFilename();

        String suffix = StringUtils.substringAfter(oname, ".");


        // 访问路径 https://tyut.oss-cn-beijing.aliyuncs.com/edu/QQ.jpg

        String host = "https://"+properties.getBucketName()+"."+properties.getEndpoint()+"/";


        //文件名称
        String name = UUID.randomUUID().toString();

        String filename = name + "." + suffix;
        //路径名称
        String dir = properties.getFilePathName()+"/"+ LocalDate.now().toString();

        String uploadname = dir + "/" + filename;


        String url = host + uploadname;

        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = properties.getEndpoint();
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = properties.getAccessKeyId();
        String accessKeySecret = properties.getAccessKeySecret();
        String bucketName = properties.getBucketName();


        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        boolean isBucketExist = ossClient.doesBucketExist(properties.getBucketName());
        if (!isBucketExist) {
            ossClient.createBucket(properties.getBucketName());
        }
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
            ossClient.putObject(bucketName, uploadname, inputStream);
            return url;
        } catch (Exception e) {
            log.error("[文件服务]  上传失败  ");
            throw new RuntimeException("文件上传失败");
        }finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e) {
                    log.error("[文件服务]  上传失败  ");
                    throw new RuntimeException("文件上传失败");
                }
            }
            // 关闭OSSClient。
            ossClient.shutdown();
        }

    }
}
