package com.blogs.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author anthony
 * @since 2019-08-25
 */
@Data
@TableName("infos")
//@ApiModel(value="其他信息对象", description="详情信息")
public class Infos  implements Serializable{


    private static final long serialVersionUID = -1320143866653212525L;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 类型名称 如 公告 
     */
    private String name;

    /**
     * 信息
     */
    private String info;

    /**
     * 其他信息
     */

    private String otherInfo;

    /**
     * 创建或者修改日期
     */
    private LocalDateTime time;




}
