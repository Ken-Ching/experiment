package team.kc.experiment.study.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

public class SecurityFilter implements Filter {
	
	private static final String LOGIN_KEY = "loginKey";
	
	private String loginKey;
	
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("SecurityFilter Initializing...");
		
		System.out.printf( "Filter name: %s \n", filterConfig.getFilterName() );
		
		loginKey = filterConfig.getInitParameter(LOGIN_KEY);
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpResp = (HttpServletResponse) response;
		String loginUser = (String) httpReq.getSession().getAttribute(loginKey);
		if ( StringUtils.isNotBlank(loginUser) ) {
			//通过验证，后续Filter链继续处理。
			doFilter(request, response, chain);
		} else {
			//验证不通过，跳到登录页面，后续Filter链不会处理。
			httpResp.sendRedirect(httpReq.getContextPath()+"/login.jsp");
		}
		
	}

	public void destroy() {
		System.out.println("SecurityFilter Destroying...");
	}

}
