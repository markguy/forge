package com.wzm.github.exception;

public class ServiceCheckedException extends BaseException {
		

	/**
	 * 
	 */
	private static final long serialVersionUID = -7082145513320159432L;

	public ServiceCheckedException(String code, String logMsg, Object[] messageArgs,
			String defaultFriendlyMessage) {
		super(code, logMsg, messageArgs, defaultFriendlyMessage);
		// TODO Auto-generated constructor stub
	}

	public ServiceCheckedException(String code, String logMsg, Object[] messageArgs) {
		super(code, logMsg, messageArgs);
		// TODO Auto-generated constructor stub
	}

	public ServiceCheckedException(String code, String logMsg,
			String defaultFriendlyMessage) {
		super(code, logMsg, defaultFriendlyMessage);
		// TODO Auto-generated constructor stub
	}

	public ServiceCheckedException(String code, String logMsg, Throwable cause,
			Object[] messageArgs, String defaultFriendlyMessage) {
		super(code, logMsg, cause, messageArgs, defaultFriendlyMessage);
		// TODO Auto-generated constructor stub
	}

	public ServiceCheckedException(String code, String logMsg, Throwable cause,
			Object[] messageArgs) {
		super(code, logMsg, cause, messageArgs);
		// TODO Auto-generated constructor stub
	}

	public ServiceCheckedException(String code, String logMsg, Throwable cause,
			String defaultFriendlyMessage) {
		super(code, logMsg, cause, defaultFriendlyMessage);
		// TODO Auto-generated constructor stub
	}

	public ServiceCheckedException(String code, String logMsg, Throwable cause) {
		super(code, logMsg, cause);
		// TODO Auto-generated constructor stub
	}

	public ServiceCheckedException(String code, String logMsg) {
		super(code, logMsg);
		// TODO Auto-generated constructor stub
	}

	public ServiceCheckedException(String code, Throwable cause, Object[] messageArgs,
			String defaultFriendlyMessage) {
		super(code, cause, messageArgs, defaultFriendlyMessage);
		// TODO Auto-generated constructor stub
	}

	public ServiceCheckedException(String code, Throwable cause, Object[] messageArgs) {
		super(code, cause, messageArgs);
		// TODO Auto-generated constructor stub
	}

	public ServiceCheckedException(String code, Throwable cause,
			String defaultFriendlyMessage) {
		super(code, cause, defaultFriendlyMessage);
		// TODO Auto-generated constructor stub
	}

	public ServiceCheckedException(String code, Throwable cause) {
		super(code, cause);
		// TODO Auto-generated constructor stub
	}

	public ServiceCheckedException(String logMsg) {
		super(logMsg);
		// TODO Auto-generated constructor stub
	}

	public ServiceCheckedException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
