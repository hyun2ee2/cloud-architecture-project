package com.caproject.member.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) {
        log.error("[ERROR] 서버 오류가 발생하였습니다.", e);

        return "[ERROR] 서버 오류가 발생했습니다.";
    }
}
