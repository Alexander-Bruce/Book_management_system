package bms.exception;

import bms.domain.Result;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result exception(Exception e) {
        e.printStackTrace();
        return Result.error(
                500,
                StringUtils.hasLength(e.getMessage()) ? e.getMessage(): "error in operation."
        );
    }
}
