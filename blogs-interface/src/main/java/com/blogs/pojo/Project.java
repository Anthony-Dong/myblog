package com.blogs.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;


import lombok.Data;

import java.io.Serializable;

import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author anthony
 * @since 2019-08-25
 */
@TableName("project")
@Data
//@ApiModel(value="project对象", description="project")
public class Project implements Serializable {


    private static final long serialVersionUID = 1790451170186686562L;
    /**
     * uuit
     */
//    @ApiModelProperty("主键id")
    @TableId(type = IdType.UUID)
    private String id;

    /**
     * 标题
     */
    private String title;


    /**
     * 作者 (默认就是我自己拉  樊浩东)
     */
    private String author;

    /**
     * 描述
     */
    private String describes;

    /**
     * 分类
     */
    private Integer category;

    /**
     * 标签-用逗号隔开
     */
    private String tag;

    /**
     * 文章封面 地址
     */
    private String image;

    /**
     * 文章 地址
     */
    private String file;

    /**
     * 创建事件
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;


}
