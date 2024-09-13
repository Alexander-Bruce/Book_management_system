package bms.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import bms.domain.ResponseBody;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseBody exception(Exception e) {
        return ResponseBody.error(
                500,
                StringUtils.hasLength(e.getMessage()) ? e.getMessage(): "error in operation."
        );
    }

    @ExceptionHandler(JwtAuthenticationException.class)
    public ResponseBody handleJwtAuthenticationException(JwtAuthenticationException e) {
        return ResponseBody.error(
                401,
                StringUtils.hasLength(e.getMessage()) ? e.getMessage(): "error in jwt authentication."
        );
    }
}
