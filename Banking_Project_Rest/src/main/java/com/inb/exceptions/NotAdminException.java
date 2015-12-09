package com.inb.exceptions;

public class NotAdminException extends Exception {
	private String message;

	public NotAdminException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public synchronized Throwable getCause() {
		return super.getCause();
	}

	@Override
	public String toString() {
		return message;
	}

}
