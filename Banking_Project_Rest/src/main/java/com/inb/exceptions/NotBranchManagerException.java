package com.inb.exceptions;

public class NotBranchManagerException  extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 100; 
	private String message;
	
	public NotBranchManagerException() {
		this.message = "USERNAME OR PASSWORD INCORRECT";
	}

	@Override
	public String getMessage() {
		return ""+serialVersionUID ;
	}

	@Override
	public synchronized Throwable getCause() {
		// TODO Auto-generated method stub
		return super.getCause();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "{\"ERROR_CODE\"':"+serialVersionUID +"}";                 //   ->"+message+" "+super.toString() ;
	}
	
	public long getSerialVersionUID()
	{
		return serialVersionUID;
	}
	
	
}
