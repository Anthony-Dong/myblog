package com.blogs.client;

import com.blogs.api.ProjectApi;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * ClassName:AdminClient
 * Package:com.blogs.client
 * Description:TODO
 *
 * @date:2019/8/27 21:10
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
@FeignClient("blogs-admin")
public interface AdminClient extends ProjectApi {

}
