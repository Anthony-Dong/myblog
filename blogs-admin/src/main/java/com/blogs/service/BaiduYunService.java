package com.blogs.service;

import com.blogs.common.util.UtilLog;
import com.blogs.dto.BaiduDto;
import com.blogs.pojo.BaiduYun;
import com.mongodb.client.result.DeleteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * ClassName:BaiduYunService
 * Package:com.blogs.service
 * Description:TODO
 *
 * @date:2019/8/28 19:26
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
@Service
public class BaiduYunService {

    @Autowired
    private MongoTemplate template;



    public String saveBaidu(BaiduDto baiduYun){

        BaiduYun save = new BaiduYun();
        save.setCreateTime(new Date());
        save.setUrl(baiduYun.getUrl());
        save.setTitle(baiduYun.getTitle());
        save.setPassword(baiduYun.getPassword());

        BaiduYun save1 = null;
        try {
             save1 = template.save(save);
        } catch (Exception e) {
            UtilLog.error("百度云服务",e,"保存失败");
        }

        return save1.getId();
    }





    public List<BaiduYun> get() {

        List<BaiduYun> baiduYuns = null;


        long count = template.count(new Query(), BaiduYun.class);

        Integer skipNum = 0;
        if (count > 30) {
            count = 30;
            skipNum = Math.toIntExact(count - 30);
        }

        try {
            Sort sort = new Sort(Sort.Direction.DESC,"createTime");
            Query query = new Query().with(sort).skip(skipNum);
            baiduYuns = template.find(query, BaiduYun.class);
        } catch (Exception e) {
            UtilLog.error("百度云服务",e,"查找错误");
        }

        return baiduYuns;
    }




    public DeleteResult delete(String url) {


        DeleteResult remove = null;
        try {
            Query query = new Query().addCriteria(Criteria.where("url").is(url));
            remove = template.remove(query, BaiduYun.class);
        } catch (Exception e) {
            UtilLog.error("百度云服务",e,"删除失败,请自行删除");
        }

        return remove;
    }

}
