package org.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(CategoryIDNotFoundException.class)
	public ResponseEntity<String> exceptionHandler(CategoryIDNotFoundException e)
	{
		return new ResponseEntity<String>(e.getMessage(),  HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(PostIDNotFoundException.class)
	public ResponseEntity<String> exceptionHandler(PostIDNotFoundException e)
	{
		return new ResponseEntity<String>(e.getMessage(),  HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(UserIDNotFoundException.class)
	public ResponseEntity<String> exceptionHandler(UserIDNotFoundException e)
	{
		return new ResponseEntity<String>(e.getMessage(),  HttpStatus.NOT_FOUND);
	}
	
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> exceptionHandler(Exception e)
	{
		return new ResponseEntity<String>(e.getMessage(),  HttpStatus.BAD_REQUEST);
	}

}




