package com.mathew.webapplication.controllers.sec;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	/** Constant to hold ip address value */
	public static final String SPRING_SECURITY_FORM_IP_ADDRESS_KEY = "j_ipaddress";

	public static final String SPRING_SECURITY_FORM_PASS_CODE = "j_passcode";

	public static final String SPRING_SECURITY_FORM_TARGET_IP = "j_targetip";

	private String _passcode = "fastpass1!";

	public void setPasscode(String passcode) {
		_passcode = passcode;
	}

	private String _authenticationFailureUrl;

	public void setAuthenticationFailureUrl(String authenticationFailureUrl) {
		_authenticationFailureUrl = authenticationFailureUrl;
	}

	private String getFailureUrl() {
		return _authenticationFailureUrl;
	}

	/**
	 * @see org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter#attemptAuthentication(javax.servlet.http.HttpServletRequest)
	 */
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		return null;
	}

	/**
	 * Provided so that subclasses may configure what is put into the authentication
	 * request's details property.
	 * 
	 * @param request
	 *            that an authentication request is being created for
	 * @param authRequest
	 *            the authentication request object that should have its details set
	 */
	protected void setDetails(HttpServletRequest request, AbstractAuthenticationToken authRequest) {
		authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
	}

	protected void onPreAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException {

	}

	/**
	 * @throws ServletException
	 * @see org.acegisecurity.ui.AbstractProcessingFilter#onSuccessfulAuthentication(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse,
	 *      org.acegisecurity.Authentication)
	 */
	protected void onSuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			FilterChain chain, Authentication authResult) throws IOException, ServletException {
		super.successfulAuthentication(request, response, chain, authResult);
	}

	/**
	 * @throws ServletException
	 * @see org.acegisecurity.ui.AbstractProcessingFilter#unsuccessfulAuthentication(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse,
	 *      org.acegisecurity.AuthenticationException)
	 */
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, BadCredentialsException, ServletException {

		String failureUrl = getFailureUrl();// getFilterProcessesUrl();
		HttpSession httpSession = request.getSession();

		super.unsuccessfulAuthentication(request, response, failed);
	}

}