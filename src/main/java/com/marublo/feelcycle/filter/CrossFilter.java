package com.marublo.feelcycle.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CrossFilter implements Filter{
	 @Override
	  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	        HttpServletRequest req = (HttpServletRequest)request;
	        HttpServletResponse res = (HttpServletResponse)response;
	 
	        res.setHeader("Access-Control-Allow-Origin", "*");
	        res.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, DELETE, OPTIONS");
	        res.setHeader("Access-Control-Allow-Headers", req.getHeader("Access-Control-Request-Headers"));
	        res.setHeader("Access-Control-Max-Age", "-1");
	 
	        chain.doFilter(req, res);
	 
	    }
	 
	 @Override
	    public void destroy() { }
	 
	 @Override
	    public void init(FilterConfig filterConfig) throws ServletException { }

}
