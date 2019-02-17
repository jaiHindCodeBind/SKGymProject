package com.codeBind.gymMgmt;

public class GymException extends Exception{


	private static final long serialVersionUID = 1L;
	
    //private String errorCode= ErrorCodes.GENERAL_EXCEPTION_KEY;
	private String errorCode= "Please Contact Administrator";
	
	public GymException() {
		super();
	}
	
	public GymException(String message, String errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public GymException(String message, Throwable exception) {
		super(message, exception);
	}

	public GymException(String message) {
		super(message);
	}

	public GymException(Throwable exception) {
		super(exception);
	}
	
	public GymException(Throwable exception, String errorCode) {
		super(exception);
		this.errorCode = errorCode;
	}
	
	  /**
     * @return String
     */
    public String getErrorCode() {
    	return errorCode;
    }

    /**
     * @param String errorCode
     */
    public void setErrorCode(String errorCode) {
    	this.errorCode = errorCode;
    }

}
