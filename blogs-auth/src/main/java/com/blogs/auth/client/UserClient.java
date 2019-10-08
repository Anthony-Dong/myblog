package com.blogs.auth.client;

import com.blogs.api.UserAuthAPI;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * ClassName:UserClient
 * Package:com.blogs.auth.client
 * Description:TODO
 *
 * @date:2019/8/24 15:43
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
@FeignClient("blogs-admin")
public interface UserClient extends UserAuthAPI {
}
