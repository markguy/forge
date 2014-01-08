package com.wzm.github.log;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.slf4j.Logger;
import org.slf4j.Marker;

import com.google.gson.Gson;
/**
 * 
 * @author rubi
 *
 */
public class MLWLogger{

	private Logger logger;
	
	public MLWLogger(Logger logger) {
		this.logger = logger;
	}

	/**
	 * 错误日志
	 * @param t 异常
	 * @param remark 当时运行时环境参数
	 * @param module Module的枚举类
	 * @param clientIp 客户端IP,例如从Request取得
	 */
	public void error(Throwable throwable,Object remark,String clientIp){
		Object[] argArray  = new Object[4];
		argArray[0] = throwable;
		Gson gson = new Gson();
		argArray[1] = gson.toJson(remark);
		argArray[2] = clientIp;
		
		StringWriter sw = new StringWriter();  
        PrintWriter pw = new PrintWriter(sw);  
        if(throwable!=null){
        		throwable.printStackTrace();
        		throwable.printStackTrace(pw);
        }
		logger.error(sw.toString()+"{}{}{}", argArray);
	}

	/**
	 * 消息日志
	 * @param info 提示信息
	 * @param remark 当时运行时环境参数,格式 orderid(1233423523),uid(2334)
	 * @param module Module的枚举类
	 * @param clientIp 客户端IP,例如从Request取得
	 */
	public void info(String info,Object remark,String clientIp){
		Object[] argArray  = new Object[4];
		argArray[0] = info;
		Gson gson = new Gson();
		argArray[1] = gson.toJson(remark);
		argArray[2] = clientIp;
		logger.info(info+"{}{}{}", argArray);
	}
	
	/**
	 * 消息日志
	 * @param info 提示信息
	 * @param remark 当时运行时环境参数,格式 orderid(1233423523),uid(2334)
	 * @param module Module的枚举类
	 * @param clientIp 客户端IP,例如从Request取得
	 */
	public void warn(String info,Object remark,String clientIp){
		Object[] argArray  = new Object[4];
		argArray[0] = info;
		Gson gson = new Gson();
		argArray[1] = gson.toJson(remark);
		argArray[2] = clientIp;
		logger.warn(info+"{}{}{}", argArray);
	}
	
	/**
	   * Is the logger instance enabled for the ERROR level?
	   * @return True if this Logger is enabled for the ERROR level,
	   * false otherwise.
	   */
	  public boolean isErrorEnabled(){
		  return logger.isErrorEnabled();
	  }
	  
	/**
	   * Is the logger instance enabled for the INFO level?
	   * @return True if this Logger is enabled for the INFO level,
	   * false otherwise.
	   */
	  public boolean isInfoEnabled(){
		  return logger.isInfoEnabled();
	  }
	  
	 /**
	   * Is the logger instance enabled for the WARN level?
	   * @return True if this Logger is enabled for the WARN level,
	   * false otherwise.
	   */
	  public boolean isWarnEnabled(){
		  return logger.isWarnEnabled();
	  }
	  
	  
	/**
	   * Is the logger instance enabled for the DEBUG level?
	   * @return True if this Logger is enabled for the DEBUG level,
	   * false otherwise.
	   * 
	   */
	  public boolean isDebugEnabled(){
		  return logger.isDebugEnabled();
	  }
	
	/**
	   * Log a message at the DEBUG level.
	   *
	   * @param msg the message string to be logged
	   */
	  public void debug(String msg){
		  logger.debug(msg);
	  }
	  
	  
	  /**
	   * Log a message at the DEBUG level according to the specified format
	   * and argument.
	   * 
	   * <p>This form avoids superfluous object creation when the logger
	   * is disabled for the DEBUG level. </p>
	   *
	   * @param format the format string 
	   * @param arg  the argument
	   */
	  public void debug(String format, Object arg){
		  logger.debug(format, arg);
	  }


	  
	  /**
	   * Log a message at the DEBUG level according to the specified format
	   * and arguments.
	   * 
	   * <p>This form avoids superfluous object creation when the logger
	   * is disabled for the DEBUG level. </p>
	   *
	   * @param format the format string
	   * @param arg1  the first argument
	   * @param arg2  the second argument
	   */
	  public void debug(String format, Object arg1, Object arg2){
		  logger.debug(format, arg1,arg2);
	  }

	  /**
	   * Log a message at the DEBUG level according to the specified format
	   * and arguments.
	   * 
	   * <p>This form avoids superfluous object creation when the logger
	   * is disabled for the DEBUG level. </p>
	   *
	   * @param format the format string
	   * @param argArray an array of arguments
	   */
	  public void debug(String format, Object[] argArray){
		  logger.debug(format, argArray);
	  }
	  
	  /**
	   * Log an exception (throwable) at the DEBUG level with an
	   * accompanying message. 
	   * 
	   * @param msg the message accompanying the exception
	   * @param t the exception (throwable) to log
	   */ 
	  public void debug(String msg, Throwable t){
		  logger.debug(msg, t);
	  }
	 
	  
	  /**
	   * Log a message with the specific Marker at the DEBUG level.
	   * 
	   * @param marker the marker data specific to this log statement
	   * @param msg the message string to be logged
	   */
	  public void debug(Marker marker, String msg){
		  logger.debug(marker, msg);
	  }
	  
	  /**
	   * This method is similar to {@link #debug(String, Object)} method except that the 
	   * marker data is also taken into consideration.
	   * 
	   * @param marker the marker data specific to this log statement
	   * @param format the format string
	   * @param arg the argument
	   */
	  public void debug(Marker marker, String format, Object arg){
		  logger.debug(marker, format,arg);
	  }
	 
	 
	  /**
	   * This method is similar to {@link #debug(String, Object, Object)}
	   * method except that the marker data is also taken into
	   * consideration.
	   *
	   * @param marker the marker data specific to this log statement
	   * @param format  the format string
	   * @param arg1  the first argument
	   * @param arg2  the second argument
	   */
	  public void debug(Marker marker, String format, Object arg1, Object arg2){
		  logger.debug(marker, format,arg1,arg2);
	  }

	  /**
	   * This method is similar to {@link #debug(String, Object[])}
	   * method except that the marker data is also taken into
	   * consideration.
	   *
	   * @param marker the marker data specific to this log statement
	   * @param format  the format string
	   * @param argArray an array of arguments
	   */
	  public void debug(Marker marker, String format, Object[] argArray){
		  logger.debug(marker, format,argArray);
	  }

	  
	  /**
	   * This method is similar to {@link #debug(String, Throwable)} method except that the
	   * marker data is also taken into consideration.
	   * 
	   * @param marker the marker data specific to this log statement
	   * @param msg the message accompanying the exception
	   * @param t the exception (throwable) to log
	   */ 
	  public void debug(Marker marker, String msg, Throwable t){
		  logger.debug(marker, msg,t);
	  }
	  
	  public static void main(String[] args) {
		 
	}
}
