/**
 * 
 */
package com.ask.security;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.ask.constn.CommonConstants;
import com.ask.pojo.ErrorMessage;

/**
 * @author ASK
 *
 */
@Component("restAuthenticationEntryPoint")
public final class RestAuthenticationEntryPoint implements
		AuthenticationEntryPoint {
	@Autowired
	MessageSource messageSource;
	
	@Autowired
	MessageSource errorRequestStatus;
	
	@Autowired
	MessageSource errorCode;
	
	
	/**
	 * @return the messageSource
	 */
	public MessageSource getMessageSource() {
		return messageSource;
	}


	/**
	 * @param messageSource the messageSource to set
	 */
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}


	/**
	 * @return the errorRequestStatus
	 */
	public MessageSource getErrorRequestStatus() {
		return errorRequestStatus;
	}


	/**
	 * @param errorRequestStatus the errorRequestStatus to set
	 */
	public void setErrorRequestStatus(MessageSource errorRequestStatus) {
		this.errorRequestStatus = errorRequestStatus;
	}


	/**
	 * @return the errorCode
	 */
	public MessageSource getErrorCode() {
		return errorCode;
	}


	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(MessageSource errorCode) {
		this.errorCode = errorCode;
	}


	@Override
	public final void commence(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException authException)
			throws IOException {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setErrorCode(errorCode.getMessage(CommonConstants.UNAUTHORIZED_ACCESS, null,Locale.US));
		errorMessage.setErrorMessage(messageSource.getMessage(CommonConstants.UNAUTHORIZED_ACCESS, null,Locale.US));
		
		response.setStatus(Integer.parseInt(errorRequestStatus.getMessage(CommonConstants.UNAUTHORIZED_ACCESS, null,Locale.US)));
		response.getWriter().write(errorMessage.toString());
	}
}