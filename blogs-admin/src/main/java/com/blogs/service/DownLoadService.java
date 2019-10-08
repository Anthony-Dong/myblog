package com.blogs.service;

import com.blogs.common.util.UtilLog;
import com.blogs.pojo.Project;
import com.blogs.service.impl.ProjectServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;


/**
 * ClassName:DownLoadService
 * Package:com.blogs.service
 * Description:TODO
 *
 * @date:2019/8/27 21:06
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
@Slf4j
@Service
public class DownLoadService {




    @Autowired
    private ProjectServiceImpl service;


    public HashMap<String, Object> getProject(String id) {

        HashMap<String, Object> map = null;
        try {
            Project project = service.findByProjectId(id);

            String fileUrl = project.getFile();

            StringBuilder fileContent = getFileString(fileUrl);

            map = new HashMap<>();

            map.put("project", project);

            map.put("file", fileContent);
            return map;
        } catch (Exception e) {
            UtilLog.error("下载服务",e,"文件下载错误");
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("file", "文件加载失败,对不起");
            return hashMap;
        }

    }


    public  StringBuilder getFileString(String  path){
        StringBuilder builder = new StringBuilder();
        BufferedInputStream inStream = null;
        try {
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            // 连接超时  3S,
            conn.setConnectTimeout(3000);
            inStream = new BufferedInputStream(conn.getInputStream());
            byte[] buffer = new byte[12040];
            int bytes = 0;
            while ((bytes = inStream.read(buffer)) != -1) {
                builder.append(new String(buffer, 0, bytes, "UTF-8"));
            }
            return builder;
        } catch (Exception e) {
            UtilLog.error("下载服务",e,path);
            return new StringBuilder("加载文件超时,对不起请稍后重试");
        }finally {
            if (inStream != null) {
                try {
                    inStream.close();
                } catch (Exception e) {
                    UtilLog.error("下载服务",e,"下载文件出现异常");
                }
            }
        }
    }

    public HashMap<String, Object> readFile(String id) {
        StringBuilder fileString = null;
        try {
            fileString = getFileString(id);
        } catch (Exception e) {
            UtilLog.error("下载服务",e,"下载个人文件出问题");
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("content", fileString);
        return hashMap;
    }
}
