package com.blogs.service;

import com.blogs.common.util.UtilLog;
import com.blogs.pojo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


import java.util.*;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * ClassName:MailService
 * Package:com.blogs.service
 * Description:TODO
 *
 * @date:2019/8/28 12:27
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

@Service
public class MailService {

    @Value("${spring.mail.username}")
    private  String myMail;

    @Autowired
    private MongoTemplate template;



    @Autowired
    private JavaMailSenderImpl javaMailSender;

    public List<String> getMail() {

        List<String> collect = null;
        try {
            List<User> users = template.findAll(User.class);
            collect = users.stream().map(User::getEmail).filter(s -> {
                String pattern = "([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})";
                return Pattern.matches(pattern, s);
            }).collect(Collectors.toList());
//            return collect;
        } catch (Exception e) {
            UtilLog.error("邮件服务", e,"生成邮件地址列表错误");
        }
        return collect;
    }


    public void sendMail(String subject, String html){

        List<String> mails = getMail();

        for (String mail : mails) {
            try {
                javaMailSender.send(mimeMessage -> {
                    MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
                    helper.setTo(mail);
                    helper.setSubject(subject);
                    helper.setText(html, true);
                    helper.setFrom(myMail);
                    helper.setSentDate(new Date());
                });
            } catch (Exception e) {
                UtilLog.error("邮件服务", e,mail);
            }
        }

    }


}
