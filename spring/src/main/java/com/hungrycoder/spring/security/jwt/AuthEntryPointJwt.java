package com.hungrycoder.spring.security.jwt;

import java.io.IOException; // Import IOException for handling input/output exceptions

import jakarta.servlet.ServletException; // Import ServletException for servlet-related exceptions
import jakarta.servlet.http.HttpServletRequest; // Import HttpServletRequest for handling HTTP requests
import jakarta.servlet.http.HttpServletResponse; // Import HttpServletResponse for handling HTTP responses

import org.slf4j.Logger; // Import Logger for logging errors and information
import org.slf4j.LoggerFactory; // Import LoggerFactory for creating Logger instances
import org.springframework.security.core.AuthenticationException; // Import AuthenticationException for authentication errors
import org.springframework.security.web.AuthenticationEntryPoint; // Import AuthenticationEntryPoint for handling unauthorized access
import org.springframework.stereotype.Component; // Import Component for Spring component scanning

@Component
public class AuthEntryPointJwt implements AuthenticationEntryPoint {

	private static final Logger logger = LoggerFactory.getLogger(AuthEntryPointJwt.class); // Logger for logging errors

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
						 AuthenticationException authException) throws IOException, ServletException {
		// Log the unauthorized access attempt with the exception message
		logger.error("Unauthorized error: {}", authException.getMessage());

		// Send an HTTP response with a 401 Unauthorized status and an error message
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error: Unauthorized");
	}

}
