/**
 * 
 */
package com.avinash.taskmanager.demo.tasks.execptions;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.common.exceptions.UnauthorizedUserException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.avinash.taskmanager.demo.common.exceptions.HttpExceptionHandler;
import com.avinash.taskmanager.demo.common.exceptions.RestErrorResponse;

/**
 * @author Avinash
 *
 */
@RestControllerAdvice
public class TasksHttpExceptionHandler extends HttpExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(TasksHttpExceptionHandler.class);

	private static final String FAILED = "failed";
	
	@ExceptionHandler(NotFoundException.class)
	public RestErrorResponse onNotFoundException(NotFoundException unfex, HttpServletRequest request) {
		String requestUri = request.getRequestURI().toString();
		logger.error(requestUri, unfex);

		return new RestErrorResponse(FAILED, unfex.getMessage(), requestUri, HttpStatus.NOT_FOUND,
				String.valueOf(HttpStatus.NOT_FOUND.value()) + " - " + HttpStatus.NOT_FOUND.getReasonPhrase());

	}

	@ExceptionHandler(InActiveUserException.class)
	public RestErrorResponse onInActiveUserException(InActiveUserException inaex, HttpServletRequest request) {
		String requestUri = request.getRequestURI().toString();
		logger.error(requestUri, inaex);

		return new RestErrorResponse(FAILED, inaex.getMessage(), requestUri, HttpStatus.FORBIDDEN,
				String.valueOf(HttpStatus.FORBIDDEN.value()) + " - " + HttpStatus.FORBIDDEN.getReasonPhrase());

	}
	
	@ExceptionHandler(UnauthorizedUserException.class)
	public RestErrorResponse onInActiveUserException(UnauthorizedUserException unauthex, HttpServletRequest request) {
		String requestUri = request.getRequestURI().toString();
		logger.error(requestUri, unauthex);

		return new RestErrorResponse(FAILED, unauthex.getMessage(), requestUri, HttpStatus.UNAUTHORIZED,
				String.valueOf(HttpStatus.UNAUTHORIZED.value()) + " - " + HttpStatus.UNAUTHORIZED.getReasonPhrase());

	}
}
