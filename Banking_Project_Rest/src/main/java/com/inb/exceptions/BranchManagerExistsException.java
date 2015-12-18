package com.inb.exceptions;

public class BranchManagerExistsException  extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 105; 
	private String message;
	
	public BranchManagerExistsException() {
		this.message = "BranchManagerExistsException";
	}

	public BranchManagerExistsException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}

	@Override
	public synchronized Throwable getCause() {
		return super.getCause();
	}

	@Override
	public String toString() {
		return "{\"ERROR_CODE\"':"+serialVersionUID+"}";                 
	}
	
	public long getSerialVersionUID()
	{
		return serialVersionUID;
	}
	
	
}
