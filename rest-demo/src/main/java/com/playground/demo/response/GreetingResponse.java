package com.playground.demo.response;

public class GreetingResponse {
	private static final String template = "Hello, %s!";
	
	private String message;

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 
	 * @param message
	 */
	public GreetingResponse(String name) {
		super();
		this.message = String.format(template, name);
	}
	
	

}
