package bms.exception;

import bms.domain.ResponseBody;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseBody exception(Exception e) {
		return ResponseBody.error(500, StringUtils.hasLength(e.getMessage()) ? e.getMessage() : "error in operation.");
	}

}
