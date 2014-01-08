package com.wzm.github.exception;

import com.wzm.github.exception.utils.CommonExceptionUtils;

/**
 * Handy class for wrapping runtime <code>Exceptions</code> with a root cause.
 *
 * <p>This class is <code>abstract</code> to force the programmer to extend
 * the class. <code>getMessage</code> will include nested exception
 * information; <code>printStackTrace</code> and other like methods will
 * delegate to the wrapped exception, if any.
 */

public abstract class AbstractNestedException extends Exception {
	/**
	 * serial number
	 */
	private static final long serialVersionUID = 7534751658054481518L;
	
	/**
	 * Construct a <code>AbstractNestedRuntimeException</code> with
	 * the specified detail message.
	 * @param cause the nested exception
	 */
	public AbstractNestedException(Throwable cause) {
		super(cause);
	}

	

	/**
	 * Construct a <code>AbstractNestedRuntimeException</code> with
	 * the specified detail message.
	 * @param msg the detail message
	 */
	public AbstractNestedException(final String msg) {
		super(msg);
	}

	/**
	 * Construct a <code>AbstractNestedRuntimeException</code> with
	 * the specified detail message
	 * and nested exception.
	 * @param msg the detail message
	 * @param cause the nested exception
	 */
	public AbstractNestedException(String msg, Throwable cause) {
		super(msg, cause);
	}


	/**
	 * Return the detail message, including the message from the nested exception
	 * if there is one.
	 */
	@Override
	public String getMessage() {
		return CommonExceptionUtils.buildMessage(super.getMessage(), getCause());
	}


	/**
	 * Retrieve the innermost cause of this exception, if any.
	 * @return the innermost exception, or <code>null</code> if none
	 * 
	 */
	public Throwable getRootCause() {
		Throwable rootCause = null;
		Throwable cause = getCause();
		while (cause != null && cause != rootCause) {
			rootCause = cause;
			cause = cause.getCause();
		}
		return rootCause;
	}

	/**
	 * Retrieve the most specific cause of this exception, that is,
	 * either the innermost cause (root cause) or this exception itself.
	 * <p>Differs from {@link #getRootCause()} in that it falls back
	 * to the present exception if there is no root cause.
	 * @return the most specific cause (never <code>null</code>)
	 * 	
	 * */
	public Throwable getMostSpecificCause() {
		Throwable rootCause = getRootCause();
		return (rootCause != null ? rootCause : this);
	}

	/**
	 * Check whether this exception contains an exception of the given type:
	 * either it is of the given class itself or it contains a nested cause
	 * of the given type.
	 * @param exType the exception type to look for
	 * @return whether there is a nested exception of the specified type
	 */
	@SuppressWarnings("rawtypes")
	public boolean contains(Class exType) {
		if (exType == null) {
			return false;
		}
		if (exType.isInstance(this)) {
			return true;
		}
		Throwable cause = getCause();
		if (cause == this) {
			return false;
		}
		if (cause instanceof AbstractNestedException) {
			return ((AbstractNestedException) cause).contains(exType);
		}
		else {
			while (cause != null) {
				if (exType.isInstance(cause)) {
					return true;
				}
				if (cause.getCause() == cause) {
					break;
				}
				cause = cause.getCause();
			}
			return false;
		}
	}
}
