package edu.springwork.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<Object> handleUserNotFoundException(UserException userException) {
		HttpStatus badRequest = HttpStatus.BAD_REQUEST;
		ApiExceptionResponse api = new ApiExceptionResponse(userException.getMessage(), HttpStatus.BAD_REQUEST,
				LocalDateTime.now());
		return new ResponseEntity<>(api, badRequest);
	}

}
