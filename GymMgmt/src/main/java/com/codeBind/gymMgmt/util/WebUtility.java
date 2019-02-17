package com.codeBind.gymMgmt.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codeBind.gymMgmt.model.Vo.AccessGroupVo;
import com.codeBind.gymMgmt.model.Vo.UserVo;



public class WebUtility {
	/**
	 * @return associated request object
	 */
	public static final String UNAUTHORIZED_VIEW = "unauthorized.view";
	
	public static HttpServletRequest getRequest() {
		return (HttpServletRequest) ThreadLocalUtility.getFromThreadLocal(Constants.HTTP_REQUEST);
	}

	/**
	 * @return associated response object
	 */
	public static HttpServletResponse getResponse() {
		return (HttpServletResponse) ThreadLocalUtility.getFromThreadLocal(Constants.HTTP_RESPONSE);
	}

	/**
	 * @return associated session object
	 */
	public static HttpSession getSession() {
		return ((HttpServletRequest) ThreadLocalUtility.getFromThreadLocal(Constants.HTTP_REQUEST)).getSession();
	}

	/**
	 * @param String key
	 * @param Object value
	 */
	public static void setSessionAttribute(String key, Object value) {
		getSession().setAttribute(key, value);
	}

	/**
	 * @return String
	 */
	public static String getServiceSession() {
		return (String) getSession().getAttribute(Constants.SERVICE_SESSION_ATTRIBUTE);
	}

	/**
	 * @param String services
	 */
	public static void setServiceSession(String services) {
		getSession().setAttribute(Constants.SERVICE_SESSION_ATTRIBUTE, services);
	}

	/**
	 * @return UserVo
	 */
	public static UserVo getUserSession() {
		return (UserVo) getSession().getAttribute(Constants.USER_SESSION_ATTRIBUTE);
	}

	/**
	 * @param UserVo
	 */
	public static void setUserSession(UserVo vo) {
		getSession().setAttribute(Constants.USER_SESSION_ATTRIBUTE, vo);
	}

	public static boolean validateUser(String module, String action) {

		UserVo userVO = getUserSession();
		List<AccessGroupVo> accessGrpList = userVO.getAccessGroupList();
		int accessGrpCount = accessGrpList.size();
		boolean returnFlag = false;
		AccessGroupVo accessGroupVO = null;
		String moduleId = null;
		
		for (int i = 0; i < accessGrpCount; i++) {
			accessGroupVO = accessGrpList.get(i);
			moduleId = accessGroupVO.getMstModuleCode();
		
			// 1.9 start, if block introduced for checking of user authorization
			// on specific module
			if (moduleId.equalsIgnoreCase(module)) {
				
				if (action.equalsIgnoreCase(Constants.Actions.CREATE_ACTION)) {					
					if (accessGroupVO.getCrAccess() == 1) {						
						returnFlag = true;
						break;
					}
				}
				if (action.equalsIgnoreCase(Constants.Actions.MODIFY_ACTION)) {
					if (accessGroupVO.getMdAccess() == 1) {						
						returnFlag = true;
						break;
					}
				}
				if (action.equalsIgnoreCase(Constants.Actions.VIEW_ACTION)) {
					if (accessGroupVO.getVwAccess() == 1) {					
						returnFlag = true;
						break;
					}
				}
				if (action.equalsIgnoreCase(Constants.Actions.DELETE_ACTION)) {
					if (accessGroupVO.getDelAccess() == 1) {						
						returnFlag = true;
						break;
					}
				}
				if (action.equalsIgnoreCase(Constants.Actions.APPROVE_ACTION)) {
					if (accessGroupVO.getApproveAccess() == 1) {						
						returnFlag = true;
						break;
					}
				}
			}
		}		
		return returnFlag;
	}
	
	public static void setWindowHandle(String windowName) {
		getSession().setAttribute("windowName", windowName);
	}
		
	public static void setWindowHandleName(String windowName) {
		getSession().setAttribute("windowNameToSet", windowName);
	}
	
	public static String getWindowHandleName() {
        return (String) getSession().getAttribute("windowNameToSet");
	}

	 public static String getWindowName() {
	    return (String) getSession().getAttribute("windowName");
	 }
	 
	public static void setRedirectUrl(String windowName) {
		getSession().setAttribute("redirectUrl", windowName);
	}
	
	public static String getRedirectUrl() {
        return (String) getSession().getAttribute("redirectUrl");
	}

	public static void generateNewSession() {
		HttpSession httpSession = getRequest().getSession(false);
		if (httpSession != null) {
			httpSession.invalidate();
		}
		httpSession = getRequest().getSession(true); // create the session
	}
}
