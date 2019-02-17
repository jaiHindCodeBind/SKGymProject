package com.codeBind.gymMgmt.util;

import java.io.Serializable;

public class Constants implements Serializable {

	private static final long serialVersionUID = 8861439517211239519L;

	
	public static final String HTTP_REQUEST = "HTTP_REQUEST";
	public static final String HTTP_RESPONSE = "HTTP_RESPONSE";

	public static final String SERVICE_SESSION_ATTRIBUTE = "seviceSession";
	public static final String ACCESS_SESSION_ATTRIBUTE = "accessSession";
	public static final String USER_SESSION_ATTRIBUTE = "userSession";
	public static final String LOGIN_CHK_MSG = "loginCheckMsg";
	public static final String STRING_ERROR = "error";


	public static final String STATUS_INACTIVE = "INACTIVE";
	public static final String STATUS_ACTIVE = "ACTIVE";


	public static final String DEFAULT_LANGUAGE = "ENGLISH";
	
	public static class Actions {
		public static final String CREATE_ACTION = "CREATE";
		public static final String VIEW_ACTION = "VIEW";
		public static final String DELETE_ACTION = "DELETE";
		public static final String MODIFY_ACTION = "MODIFY";
		public static final String APPROVE_ACTION = "APPROVE";
		public static final String REVERSE_ACTION = "REVERSE";
		
	}
	
	public static class Modules {
		public static final String ADD_MEMBER = "ADD_MEMBER";
		
	}

}
