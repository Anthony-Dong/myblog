package com.blogs.repository;

import com.blogs.pojo.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;


/**
 * ClassName:MessageRepository
 * Package:com.blogs.repository
 * Description:TODO
 *
 * @date:2019/8/26 15:52
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public interface MessageRepository extends MongoRepository<Message,String> {




}
