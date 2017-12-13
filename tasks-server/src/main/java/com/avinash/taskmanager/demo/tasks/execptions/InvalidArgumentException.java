/**
 * 
 */
package com.avinash.taskmanager.demo.tasks.execptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Avinash
 *
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidArgumentException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -621123854332411655L;

	public InvalidArgumentException(String message) {
		super(message);
	}

	public InvalidArgumentException(String message, Throwable t) {
		super(message, t);
	}
}
