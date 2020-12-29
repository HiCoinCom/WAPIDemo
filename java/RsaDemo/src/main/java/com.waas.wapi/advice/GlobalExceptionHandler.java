package com.chainup.baas.advice;


import com.google.common.collect.Maps;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

/**
 * @author zyq
 */
@Log4j2
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Throwable.class)
    public Object methodArgumentNotValid(Throwable ex) {
        Map<String, Object> map = Maps.newHashMap();
        ex.printStackTrace();
        map.put("code", -1);
        map.put("mag", "系统异常");
        return map;
    }

}

