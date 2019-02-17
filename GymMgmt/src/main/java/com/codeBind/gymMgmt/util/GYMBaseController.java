package com.codeBind.gymMgmt.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codeBind.gymMgmt.model.Vo.UserVo;



public class GYMBaseController {

	public static final String UNAUTHORIZED_VIEW = "unauthorized.view";

	/**
	 * @return associated request object
	 */
	protected HttpServletRequest getRequest() {
		return WebUtility.getRequest();
	}

	/**
	 * @return associated response object
	 */
	protected HttpServletResponse getResponse() {
		return WebUtility.getResponse();
	}

	/**
	 * @return associated session object
	 */
	protected HttpSession getSession() {
		return WebUtility.getSession();
	}

	/**
	 * @return UserVo
	 */
	protected UserVo getUserSession() {
		return WebUtility.getUserSession();
	}

	/**
	 * @param UserVo vo
	 */
	protected void setUserSession(UserVo vo) {
		WebUtility.setUserSession(vo);
	}

	protected static boolean validateUser(String module, String action) {
		return WebUtility.validateUser(module, action);
	}

	protected void setWindowHandle(String windowHandle) {
		WebUtility.setWindowHandle(windowHandle);
		WebUtility.setWindowHandleName(windowHandle);
	}
	
	/**
	 * @return UserVo
	 */
	protected String getLoggedInUser() {
		return WebUtility.getUserSession().getLoginId();
	}

	/**
	 * Create New Session
	 */
	protected void generateNewSession() {
		WebUtility.generateNewSession();
	}
}
