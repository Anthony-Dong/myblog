package com.blogs.web;

import com.blogs.common.util.UtilLog;
import com.blogs.pojo.Article;
import com.blogs.service.ArticleService;
import com.blogs.service.MailService;
import com.mongodb.client.result.UpdateResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ClassName:MailController
 * Package:com.blogs.web
 * Description:TODO
 *
 * @date:2019/8/28 13:15
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

@RestController
@RequestMapping("message")
public class MailController {

    @Autowired
    private MailService mailService;

    @Autowired
    private ArticleService articleService;

    @GetMapping("get/article")
    public ResponseEntity<Article> getArticle(){
        Article article = articleService.getArticle();

        return ResponseEntity.ok(article);
    }


    @GetMapping("set/article")
    public ResponseEntity<UpdateResult> setArticle(@RequestParam("list") List<String> list) {
        UpdateResult updateResult = articleService.updateArticle(list);
        return ResponseEntity.ok(updateResult);
    }


    /**
     * 发送 邮件
     * @param title
     * @param content
     * @return
     */
    @GetMapping("send")
    public ResponseEntity<Void> sendMail(@RequestParam("title")String title,
                                         @RequestParam("content") String content){

        try {
            mailService.sendMail(title, content);
        } catch (Exception e) {
            UtilLog.error("消息服务",e,"发送邮件异常");
        }
        return ResponseEntity.ok().build();
    }

}
