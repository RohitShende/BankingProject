package com.inb.exceptions;

public class NotBranchManagerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 101; 
	private String message="USERNAME OR PASSWORD INCORRECT";
	
	public NotBranchManagerException() {
		
	}
	
	public NotBranchManagerException(String msg) {
		System.out.println("Inside Exception :- "+msg);
		this.message = this.message+"/"+msg;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

	@Override
	public String toString() {
		return "{ \"Exception\":\""+this.message+"\"}";         
	}
	
	
}
