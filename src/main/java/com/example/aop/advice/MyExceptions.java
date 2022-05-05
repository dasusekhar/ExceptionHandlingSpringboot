package com.example.aop.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.aop.exception.BusinessException;
import com.example.aop.exception.NoSuchElementException;

@RestControllerAdvice
public class MyExceptions  {
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> handleInvalidArgument(MethodArgumentNotValidException ex)
	{
		Map<String,String> errorMap=new HashMap<>();
		 ex.getBindingResult().getFieldErrors().forEach(error->{
			errorMap.put(error.getField(),error.getDefaultMessage());
		});
		return errorMap;
		
		
	}
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<String> handleBusiness(BusinessException exception)
	{
		return new ResponseEntity<String>("empty the list not data here to reurn ...!",HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(NoSuchElementException.class)
  public ResponseEntity<String> handleNoIds(NoSuchElementException exes)
  {
	  return new ResponseEntity<String>("that id number not present in the record",HttpStatus.NOT_FOUND);
  }
	
	

}
