package cn.sxgan.common.exception;

import cn.sxgan.common.enums.ResponseStatus;
import cn.sxgan.common.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * @Description: 全局异常处理器
 * @Author: sxgan
 * @Date: 2024/3/1 15:07
 * @Version: 1.0
 **/
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    // 指定出现什么异常执行这个方法
    @ExceptionHandler(Exception.class)
    @ResponseBody // 为了返回数据
    public ResponseResult<String> error(Exception e) {
        e.printStackTrace();
        log.error("GlobalExceptionHandler Exception e {}", ExceptionUtils.getMessage(e));
        return ResponseResult.fail(ResponseStatus.HTTP_STATUS_500.getMsg());
    }
    
    // 自定义异常
    @ExceptionHandler(AuthorityException.class)
    @ResponseBody
    public ResponseResult<String> error(AuthorityException e) {
        log.error(ExceptionUtils.getMessage(e));
        e.printStackTrace();
        log.error("AuthorityException Exception e {}", ExceptionUtils.getMessage(e));
        return ResponseResult.fail(e.getMsg());
    }
    
    // 特定异常
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody // 为了返回数据
    public ResponseResult<String> error(ArithmeticException e) {
        e.printStackTrace();
        log.error("ArithmeticException Exception e {}", ExceptionUtils.getMessage(e));
        return ResponseResult.fail("执行了ArithmeticException异常处理..");
    }
    
    // 特定异常
    @ExceptionHandler(value = {IOException.class, HttpMessageNotWritableException.class})
    @ResponseBody // 为了返回数据
    public ResponseResult<String> error(IOException e) {
        // e.printStackTrace();
        
        log.error("IOException Exception e {}", ExceptionUtils.getMessage(e));
        return ResponseResult.fail("执行了IOException异常处理..");
    }
    
    
}
