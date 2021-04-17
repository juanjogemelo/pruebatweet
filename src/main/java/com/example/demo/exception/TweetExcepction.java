package com.example.demo.exception;

public class TweetExcepction extends RuntimeException {

	/**
	 * SerialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Excepcion de tweet.
	 * @param exception mensaje.
	 */
	public TweetExcepction(String exception) {
		super(exception);
	}
	
}
