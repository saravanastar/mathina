/**
 * 
 */
package com.ask.mtradus.exception;

/**
 * @author Gerard
 *
 */
public class BusinessException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1673613560697735021L;
	private String messageKey;

	public BusinessException() {
		// TODO Auto-generated constructor stub
	}

	public BusinessException(String messageKey) {
		super(messageKey);
		this.messageKey = messageKey;
	}

	public String getMessageKey() {
		return messageKey;
	}

	public void setMessageKey(String messageKey) {
		this.messageKey = messageKey;
	}
}
