package com.inb.exceptions;

public class InvalidInputException  extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 106; 
	private String message;
	
	public InvalidInputException() {
		this.message = "InvalidInputException";
	}

	public InvalidInputException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}

	@Override
	public synchronized Throwable getCause() {
		// TODO Auto-generated method stub
		return super.getCause();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "{\"ERROR_CODE\"':"+serialVersionUID+"}";                 //   ->"+message+" "+super.toString() ;
	}
	
	public long getSerialVersionUID()
	{
		return serialVersionUID;
	}
	
	
}
