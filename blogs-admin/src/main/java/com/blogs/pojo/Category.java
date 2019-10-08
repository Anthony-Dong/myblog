package com.blogs.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author anthony
 * @since 2019-08-25
 */
@Data
@TableName("category")
//@ApiModel(value="category对象", description="文档分类")
public class Category implements Serializable {


    private static final long serialVersionUID = -5222962393866274779L;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 分类详情
     */
    private String describes;

    /**
     * 父亲 id
     */
    private Integer parentId;

    /**
     * 是否是父亲 0否 1 是
     */
    private Boolean isParent;



}
