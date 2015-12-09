package com.inb.exceptions;

public class BranchAlreadyExistException  extends Exception {

	/**
	 * @author islam_s
	 *
	 */
	
	private static final long serialVersionUID = 100; 
	private String message;
	
	public BranchAlreadyExistException() {
		this.message = "BRANCH ALREADY EXIST";
	}

	@Override
	public String getMessage() {
		return 	this.message+" "+serialVersionUID ;
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
