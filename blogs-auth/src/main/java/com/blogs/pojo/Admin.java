package com.blogs.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author anthony
 * @since 2019-08-23
 */


@TableName("admin")
@Data
//@ApiModel(value="admin对象", description="我自己")
public class Admin implements Serializable {


    private static final long serialVersionUID = 1710413745071606449L;
    /**
     * 主键id
     */
//    @ApiModelProperty("主键id")
    @TableId(type = IdType.UUID)
    private String id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 性别
     */
    private Boolean gender;

    /**
     * 头像地址
     */
    private String avatar;

    /**
     * 座右铭
     */
    private String motto;
    /**
     * 生日
     */
    private LocalDate birthday;

    /**
     * 城市
     */
    private String city;

    /**
     * 省份
     */
    private String province;

    /**
     * 国家
     */
    private String country;

    /**
     * 密码
     */
    @JsonIgnore
    private String password;

    /**
     * 密码盐
     */
    @JsonIgnore
    private String salt;

    /**
     * 注册时间
     */
    private Date regTime;

    /**
     * 登录时间
     */
    @JsonIgnore
    private Date loginTime;


    private String github;


    private String email;


    private Long phone;


    private Integer auth;

}
