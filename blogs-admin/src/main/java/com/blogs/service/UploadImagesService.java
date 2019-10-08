package com.blogs.service;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.blogs.config.AliyunossProperties;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * ClassName:UploadImageService
 * Package:com.aliyun.service
 * Description:TODO
 *
 * @date:2019/8/24 23:51
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
@Service
public class UploadImagesService {

    private static final List<String> IMAGE_TYPE = Arrays.asList("image/jpeg","image/png","image/gif","image/jpg","image/svg","image/ico");



    @Autowired
    private AliyunossProperties properties;


    public String uploadImage(MultipartFile file) {
        String contentType = file.getContentType();

        if (!IMAGE_TYPE.contains(contentType)) {
            throw new RuntimeException("文件类型错误");
        }


        if (file.getSize()>properties.getImageSize()){
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
        String dir = properties.getImagePathName()+"/"+ LocalDate.now().toString();

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
            return url+"?"+properties.getStylename();
        } catch (IOException e) {
            throw new RuntimeException("文件上传失败");
        }finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException("文件上传失败");
                }
            }
            // 关闭OSSClient。
            ossClient.shutdown();
        }

    }
}
