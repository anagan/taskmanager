/**
 * 
 */
package com.avinash.taskmanager.demo.common.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Avinash
 *
 */
@RestControllerAdvice
public class HttpExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(HttpExceptionHandler.class);

	private static final String FAILED = "failed";

	@ExceptionHandler(Exception.class)
	public RestErrorResponse onException(Exception ex, HttpServletRequest request) {
		String requestUrl = request.getRequestURL().toString();
		logger.error(requestUrl, ex);

		return new RestErrorResponse(FAILED, ex.getMessage(), requestUrl, HttpStatus.INTERNAL_SERVER_ERROR,
				String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()) + " - "
						+ HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());

	}
}
