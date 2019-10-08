package com.blogs.service;

import com.blogs.common.util.UtilLog;
import com.blogs.pojo.Article;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName:ArticleService
 * Package:com.blogs.service
 * Description:TODO
 *
 * @date:2019/8/28 22:25
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
@Service
public class ArticleService {

    @Autowired
    private MongoTemplate template;



    public Article getArticle(){
        Article one = null;
        try {
            Query name = new Query().addCriteria(Criteria.where("name").is("article"));

            one = template.findOne(name, Article.class);
        } catch (Exception e) {
            UtilLog.error("文章服务",e,"查询失败");
        }

        return one;
    }




    public Article setArticle(List<String> list) {
        Article insert = null;
        try {
            Article article = new Article();
            article.setName("article");
            article.setList(list);
            insert = template.insert(article);
        } catch (Exception e) {
            UtilLog.error("文章服务",e,"设置失败");
        }
        return insert;
    }



    public UpdateResult updateArticle(List<String> list) {
        UpdateResult updateResult = null;
        try {
            Article article = new Article();
            article.setName("article");
            article.setList(list);
            Query query = new Query().addCriteria(Criteria.where("name").is("article"));
            Update update = new Update();
            update.set("list", list);
            updateResult = template.updateFirst(query, update, Article.class);
        } catch (Exception e) {
            UtilLog.error("文章服务",e,"更新失败");
        }

        return updateResult;
    }
}
