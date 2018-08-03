package com.mathew.webapplication.controllers;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

@Component("concurrentSessionFilter")
public class WebConcurrentSessionFilterImpl extends GenericFilterBean {

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		System.out.println("Before --- WebConcurrentSessionFilterImpl");
		chain.doFilter(request, response);
		System.out.println("After --- WebConcurrentSessionFilterImpl");

	}

}
