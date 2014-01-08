package com.wzm.github.exception.utils;

import java.io.PrintWriter;
import java.io.StringWriter;



/**
 * 异常工具类
 * 
 * @author gan jianfeng
 *
 */
public class CommonExceptionUtils {
	
	/**
	 * 异常处理配置对应的Spring bean 的名字，
	 */
	public static final String EXCEPTION_HANDLE_SETTING_BEAN_NAME = "exceptionHandleSetting";
	/**
	 * JmsTemplate对应的Spring bean 的名字，
	 */
	public static final String EXCEPTION_HANDLE_JMSTEMPLATE_BEAN_NAME = "exJmsTemplate";
	/**
	 * 换行符
	 */
	public static final String LINE_SEPARATOR=System.getProperty("line.separator");

	/**
	 * Build a message for the given base message and root cause.
	 * @param message the base message
	 * @param cause the root cause
	 * @return the full exception message
	 */
	public static String buildMessage(String message, Throwable cause) {
		if (cause != null) {
			StringBuilder sb = new StringBuilder();
			if (message != null) {
				sb.append(message).append("; ");
			}
			sb.append("nested exception is ").append(cause);
			return sb.toString();
		}
		else {
			return message;
		}
	}
	
	/**
	 * 得到指定异常的rootCause
	 * @param ex
	 * @return
	 */
	public static Throwable getRootCause(Throwable ex) {
		Throwable rootCause = null;
		Throwable cause = ex.getCause();
		while (cause != null && cause != rootCause) {
			rootCause = cause;
			cause = cause.getCause();
		}
		return rootCause;
	}
	/**
	 * 得到指定异常的rootCause,如果没有rootCause,则把参数指定的异常作为rootCause,
	 * 以免返回null
	 * 
	 * @param ex
	 * @return
	 */
	public static Throwable getMostSpecificCause(Throwable ex) {
		Throwable rootCause = getRootCause(ex);
		return (rootCause != null ? rootCause : ex);
	}
	
	public static String getExceptionStackTrace(Throwable ex){
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ex.printStackTrace(pw);
		pw.close();
		return sw.toString();
	}	
	
	public static String getMostSpecificCauseMessageInfo(Throwable ex){
		//get rootCause of exception
		Throwable rootCause = getMostSpecificCause(ex);								//得到根异常	
		StackTraceElement[] elements = rootCause.getStackTrace();				    //得到Stack trace的elements
				
		String rootException = rootCause.getClass().getName();	
		String rootExceptionMsg = rootCause.getLocalizedMessage();
				
		String rootCauseSpotClass = elements[0].getClassName();						//抛出根异常的类
		String rootCauseSpotMethod = elements[0].getMethodName();					//抛出根异常的方法
		int rootCauseSpotLine = elements[0].getLineNumber();						//抛出根异常的行号
		
		StringBuilder sbdr = new StringBuilder(LINE_SEPARATOR);	
		
		sbdr.append("[Root Exception]: ").append(rootException).append(LINE_SEPARATOR)
		.append("[Root Exception Message]: ").append(rootExceptionMsg).append(LINE_SEPARATOR)
		.append("[Root Exception throwed on]: ")
		.append(rootCauseSpotClass).append(".").append(rootCauseSpotMethod)
		.append("  Line:").append(rootCauseSpotLine);		
		
		return sbdr.toString();		
	}
	
	 
}
