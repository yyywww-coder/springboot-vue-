package com.woniu.exception;

import com.woniu.utils.ResponseResult;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalException {

//    @ExceptionHandler(Exception.class)
//    @ResponseBody
//    public ResponseResult<Void> permExcription(){
//        return ResponseResult.FORBIDDEN;
//    }

}
