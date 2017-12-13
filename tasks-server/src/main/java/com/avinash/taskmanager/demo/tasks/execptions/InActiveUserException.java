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
@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class InActiveUserException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7274583611497559533L;

	public InActiveUserException(String message) {
		super(message);
	}

	public InActiveUserException(String message, Throwable t) {
		super(message, t);
	}
}
