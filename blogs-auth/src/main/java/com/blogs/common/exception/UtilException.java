package com.blogs.common.exception;


import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * ClassName:UtilException
 * Package:com.blogs.com.blogs.common.exception
 * Description:
 *
 * @date:2019/8/11 22:57
 * @author: 574986060@qq.com
 */
@Data
@AllArgsConstructor
public class UtilException extends RuntimeException{

   public EnumException enumException;

}
