package com.boraydata.hygiene.web.hander;

import com.boraydata.hygiene.common.excention.BusinessException;
import com.boraydata.hygiene.web.result.MyResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionsHandler {

    @ExceptionHandler(value = {BusinessException.class})
    public MyResult BusinessExceptionHandler(BusinessException businessException) {
        log.error(businessException.getMessage());
        return MyResult.errorMsg(500, businessException.getMessage());
    }

    @ExceptionHandler(value = {Exception.class})
    public MyResult BusinessExceptionHandler(Exception exception) {
        log.error(exception.getMessage());
        return MyResult.errorMsg(500, "系统错误");
    }
}
