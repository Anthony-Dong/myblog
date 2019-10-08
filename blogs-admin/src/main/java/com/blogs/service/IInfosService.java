package com.blogs.service;

import com.blogs.pojo.Infos;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author anthony
 * @since 2019-08-25
 */
public interface IInfosService extends IService<Infos> {

    Infos findInfoByName(String name);
}
