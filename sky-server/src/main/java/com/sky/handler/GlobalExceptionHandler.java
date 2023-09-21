package com.sky.handler;

import com.sky.constant.MessageConstant;
import com.sky.exception.BaseException;
import com.sky.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 全局异常处理器，处理项目中抛出的业务异常
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 捕获业务异常
     * @param ex
     * @return
     */
    @ExceptionHandler
    public Result exceptionHandler(BaseException ex){
        log.error("异常信息：{}", ex.getMessage());
        return Result.error(ex.getMessage());
    }
    @ExceptionHandler
    public Result excepttionHandler(SQLIntegrityConstraintViolationException e){
        String ms=e.getMessage();
        //错误信息举例 Duplicate entry 'Goudan Li' for key 'employee.idx username'
        if(ms.contains("Duplicate entry")){
            return Result.error(ms.split(" ")[2]+ MessageConstant.ALREADY_EXISTS);
        }else{
            return Result.error(MessageConstant.UNKNOWN_ERROR+"非‘用户名已存在’");
        }
    }
}
