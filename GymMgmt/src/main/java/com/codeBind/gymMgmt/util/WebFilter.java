package com.codeBind.gymMgmt.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class WebFilter implements Filter {

	private static final Logger logger = LoggerFactory.getLogger(WebFilter.class);
	
	private static final boolean CONDITION = true;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.debug("Initiating WebFilter >> ");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		

		ThreadLocalUtility.addToThreadLocal(Constants.HTTP_REQUEST, request);
		ThreadLocalUtility.addToThreadLocal(Constants.HTTP_RESPONSE, response);
		
		if (CONDITION == true) {
		/*	HttpServletRequest req = (HttpServletRequest) request;
			HeaderMapRequestWrapper requestWrapper = new 
					HeaderMapRequestWrapper(req);
			String remote_addr = request.getRemoteAddr();
			requestWrapper.addHeader("remote_addr", remote_addr);*/
            // Goes to default servlet
			chain.doFilter(request, response); 
		} else {
			((HttpServletResponse) response).setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}
	
	@Override
	public void destroy() {
		logger.debug("Destroying WebFilter >> ");
	}
}
