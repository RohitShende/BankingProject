package com.inb.exceptions;

public class NotBranchManagerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 101; 
	private String message;
	
	public NotBranchManagerException() {
		this.message = "USERNAME OR PASSWORD INCORRECT";
	}

	@Override
	public String getMessage() {
		return this.message+" "+serialVersionUID ;
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
