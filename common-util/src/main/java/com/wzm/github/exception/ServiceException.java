package com.wzm.github.exception;

public class ServiceException extends BaseRuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3247671035844921552L;

	public ServiceException(String code, String logMsg, Object[] messageArgs,
			String defaultFriendlyMessage) {
		super(code, logMsg, messageArgs, defaultFriendlyMessage);
	}

	public ServiceException(String code, String logMsg, Object[] messageArgs) {
		super(code, logMsg, messageArgs);
	}

	public ServiceException(String code, String logMsg,
			String defaultFriendlyMessage) {
		super(code, logMsg, defaultFriendlyMessage);
	}

	public ServiceException(String code, String logMsg, Throwable cause,
			Object[] messageArgs, String defaultFriendlyMessage) {
		super(code, logMsg, cause, messageArgs, defaultFriendlyMessage);
	}

	public ServiceException(String code, String logMsg, Throwable cause,
			Object[] messageArgs) {
		super(code, logMsg, cause, messageArgs);
	}

	public ServiceException(String code, String logMsg, Throwable cause,
			String defaultFriendlyMessage) {
		super(code, logMsg, cause, defaultFriendlyMessage);
	}

	public ServiceException(String code, String logMsg, Throwable cause) {
		super(code, logMsg, cause);
	}

	public ServiceException(String code, String[] logMsg, Throwable cause) {
		super(code, logMsg[0], cause);
	}
	
	public ServiceException(String code, String logMsg) {
		super(code, logMsg);
	}

	public ServiceException(String code, String[] logMsg) {
		super(code, logMsg[0]);
	}
	
	public ServiceException(String code, Throwable cause, Object[] messageArgs,
			String defaultFriendlyMessage) {
		super(code, cause, messageArgs, defaultFriendlyMessage);
	}

	public ServiceException(String code, Throwable cause, Object[] messageArgs) {
		super(code, cause, messageArgs);
	}

	public ServiceException(String code, Throwable cause,
			String defaultFriendlyMessage) {
		super(code, cause, defaultFriendlyMessage);
	}

	public ServiceException(String code, Throwable cause) {
		super(code, cause);
	}

	public ServiceException(String logMsg) {
		super(logMsg);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}

}
