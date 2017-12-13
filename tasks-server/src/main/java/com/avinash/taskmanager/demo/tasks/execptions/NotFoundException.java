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
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7853285862751581059L;
	
	public NotFoundException(String message) {
		super(message);
	}

	public NotFoundException(String message, Throwable t) {
		super(message, t);
	}

}
