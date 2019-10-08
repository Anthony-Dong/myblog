package com.blogs.common.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * ClassName:HandlerException
 * Package:com.blogs.com.blogs.common.exception
 * Description:
 *
 * @date:2019/8/11 23:06
 * @author: 574986060@qq.com
 */
@ControllerAdvice
public class HandlerException {

    @ExceptionHandler(UtilException.class)
    public ResponseEntity<ExceptionResult> handler(UtilException e) {

        return ResponseEntity.status(e.getEnumException().getStatus()).body(new ExceptionResult(e));
    }

}
