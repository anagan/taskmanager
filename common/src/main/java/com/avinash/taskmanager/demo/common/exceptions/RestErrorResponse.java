/**
 * 
 */
package com.avinash.taskmanager.demo.common.exceptions;

import org.springframework.http.HttpStatus;

/**
 * @author Avinash
 *
 */
public class RestErrorResponse {

	private String status;
	private String error;
	private String message;
	private HttpStatus httpStatus;
	private String uri;
	
	public RestErrorResponse(String status, String message, String uri, String error) {
		this.status = status;
		this.message = message;
		this.uri = uri;
		this.error = error;
	}
	
	public RestErrorResponse(String status, String message, String uri, HttpStatus httpStatus) {
		this.status = status;
		this.message = message;
		this.uri = uri;
		this.httpStatus = httpStatus;
	}
	
	public RestErrorResponse(String status, String message, String uri, HttpStatus httpStatus, String error) {
		this.status = status;
		this.message = message;
		this.uri = uri;
		this.httpStatus = httpStatus;
		this.error = error;
	}
	
	public RestErrorResponse(String status, String message, String uri) {
		this.status = status;
		this.message = message;
		this.uri = uri;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}

	/**
	 * @param error the error to set
	 */
	public void setError(String error) {
		this.error = error;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the httpStatus
	 */
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	/**
	 * @param httpStatus the httpStatus to set
	 */
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	/**
	 * @return the uri
	 */
	public String getUri() {
		return uri;
	}

	/**
	 * @param uri the uri to set
	 */
	public void setUri(String uri) {
		this.uri = uri;
	}
	
}
