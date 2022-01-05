package com.nortal.platformer.exception;


public class HandledException extends Exception {

	private static final long serialVersionUID = 1L;

	public HandledException() {
		
	}

	public HandledException(String message) {
		super(message);
	}

	public HandledException(String message, Exception e) {
		super(message, e);
	}

}
