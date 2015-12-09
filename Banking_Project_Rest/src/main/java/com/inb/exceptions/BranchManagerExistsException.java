package com.inb.exceptions;

public class BranchManagerExistsException  extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 105; 
	private String message;
	
	public BranchManagerExistsException() {
		this.message = "BRANCH MANAGER ALREADY EXISTS";
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
