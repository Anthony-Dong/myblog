package com.blogs.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * ClassName:CountProject
 * Package:com.blogs.dto
 * Description:  根据  category id 查询  project中的种类 个数
 *
 * @date:2019/8/25 11:51
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
@Data
public class CountProject implements Serializable {

    private static final long serialVersionUID = -6050237006073690742L;
    private Integer id;

    private String name;

    private Integer count;

}
