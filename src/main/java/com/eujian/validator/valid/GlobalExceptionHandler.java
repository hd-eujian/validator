package com.eujian.validator.valid;

import org.slf4j.Logger;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    protected Logger log = org.slf4j.LoggerFactory.getLogger(this.getClass());


    /**
     * post请求
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String methodArgumentNotValidException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        List<FieldError> allErrors = bindingResult.getFieldErrors();
        FieldError fieldError = allErrors.get(0);
        String defaultMessage = fieldError.getDefaultMessage();
        log.info("post error msg :{}",defaultMessage);
        return defaultMessage;
    }

    /**
     * get请求
     */
    @ExceptionHandler(BindException.class)
    public String validBindException(BindException e) {
        List<FieldError> allErrors = e.getFieldErrors();
        FieldError fieldError = allErrors.get(0);
        String defaultMessage = fieldError.getDefaultMessage();
        log.info("get error msg :{}",defaultMessage);
        return defaultMessage;
    }

    /**
     * RequestParamet缺失的异常
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public String handleCommentException(MissingServletRequestParameterException e) {
        log.info(e.getParameterName());
        log.info("RequestParamet error msg :{}",e.getParameterName());
        return e.getParameterName()+"不能为空";
    }
}
