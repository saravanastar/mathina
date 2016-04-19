/**
 * 
 */
package com.ask.exception;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ask.constn.CommonConstants;
import com.ask.pojo.ErrorMessage;

/**
 * @author ASK
 *
 */
@ControllerAdvice
public class ApplicationExceptionHanlderResolver extends ResponseEntityExceptionHandler {
	@Autowired
	MessageSource messageSource;
	
	@Autowired
	MessageSource errorRequestStatus;
	
	@Autowired
	MessageSource errorCode;
	
	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setErrorCode(errorCode.getMessage(CommonConstants.BAD_REUEST, null,Locale.US));
		errorMessage.setErrorMessage(messageSource.getMessage(CommonConstants.BAD_REUEST, null,Locale.US));
		return new ResponseEntity<Object>(errorMessage, headers, HttpStatus.BAD_REQUEST);

	}

	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		ErrorMessage errorMessage = new ErrorMessage();
		if (ex instanceof BusinessException) {
			BusinessException businessException = (BusinessException) ex;
			errorMessage.setErrorCode(errorCode.getMessage(businessException.getMessageKey(), null,Locale.US));
			errorMessage.setErrorMessage(messageSource.getMessage(businessException.getMessageKey(), null,Locale.US));
			status = HttpStatus.valueOf(Integer.parseInt(errorRequestStatus.getMessage(businessException.getMessageKey(), null,Locale.US)));
		} else {
			errorMessage.setErrorCode(errorCode.getMessage(CommonConstants.INTERNAL_SERVER_ERROR, null,Locale.US));
			errorMessage.setErrorMessage(messageSource.getMessage(CommonConstants.INTERNAL_SERVER_ERROR, null,Locale.US));
			status = HttpStatus.valueOf(Integer.parseInt(errorRequestStatus.getMessage(CommonConstants.INTERNAL_SERVER_ERROR, null,Locale.US)));
		}
		return new ResponseEntity<Object>(errorMessage, headers, status);
	}

	@ExceptionHandler({ BusinessException.class })
	protected ResponseEntity<Object> handleInvalidRequest(RuntimeException e, WebRequest request) {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		return handleExceptionInternal(e, new Object(), headers, HttpStatus.UNPROCESSABLE_ENTITY, request);
	}
}
