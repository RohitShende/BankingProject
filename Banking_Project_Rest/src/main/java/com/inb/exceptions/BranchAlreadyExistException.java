package com.inb.exceptions;

public class BranchAlreadyExistException  extends Exception {

	/**
	 * @author islam_s
	 *
	 */
	
	private static final long serialVersionUID = 100; 
	private String message="BranchAlreadyExistException";
	
	public BranchAlreadyExistException() {
	
	}
	
	public BranchAlreadyExistException(String message) {
		this.message = this.message+"/"+message;
	}

	@Override
	public String getMessage() {
		return 	this.message;
	} 

	@Override
	public String toString() {
		return "{ \"Exception \": \""+this.message+"\" }";         
	}
	

}
