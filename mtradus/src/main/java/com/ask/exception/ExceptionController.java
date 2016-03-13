/**
 * 
 */
package com.ask.mtradus.exception;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ask.mtradus.pojo.ErrorMessage;

/**
 * @author ASK
 *
 */
public class ExceptionController {
	@Autowired
	ErrorMessage errorMessage;

	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}

	private static final Logger log = Logger
			.getLogger(ExceptionController.class);

	@ExceptionHandler(BusinessException.class)
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorMessage handleException(
			BusinessException businessException) {
		log.error(businessException.getMessageKey());
		errorMessage.setErrorMessage(businessException.getMessage());
		return errorMessage;
	}

}
