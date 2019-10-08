package com.blogs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.blogs.pojo.Infos;
import com.blogs.mapper.InfosMapper;
import com.blogs.service.IInfosService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author anthony
 * @since 2019-08-25
 */
@Service
public class InfosServiceImpl extends ServiceImpl<InfosMapper, Infos> implements IInfosService {
    @Autowired
    private InfosMapper mapper;

    @Override
    public Infos findInfoByName(String name) {
        if (name == null) {
            return null;
        }

        Infos infos = mapper.selectOne(new LambdaQueryWrapper<Infos>().eq(Infos::getName, name));

        if (ObjectUtils.isEmpty(infos)) {

            return null;
        }

        return infos;
    }
}
