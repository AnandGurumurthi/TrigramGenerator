package com.trigram.datahandler;

/**
 * Exception class to handle data handling related exceptions
 * 
 * @author Anand
 *
 */
public class DataHandlerException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6014374908563025566L;

	public DataHandlerException() {
	}

	public DataHandlerException(String message) {
		super(message);
	}
}
