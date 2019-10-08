package com.blogs.common.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName:ExceptionResult
 * Package:com.blogs.com.blogs.common.exception
 * Description:
 *
 * @date:2019/8/11 23:09
 * @author: 574986060@qq.com
 */

@NoArgsConstructor
@Data
public class ExceptionResult {

    private int stateCode;
    private String error;
    private Long timeStamp;


    public ExceptionResult(UtilException e) {
        this.stateCode = e.getEnumException().getStatus().value();
        this.error = e.getEnumException().getMsg();
        this.timeStamp = System.currentTimeMillis();
    }
}
