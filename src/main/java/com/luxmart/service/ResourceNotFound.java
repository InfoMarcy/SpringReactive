package com.luxmart.service;

public class ResourceNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResourceNotFound() {
		super();
	}

	public ResourceNotFound(String message, Throwable cause, boolean enabledSuppresion, boolean writableStackTrace) {
		super(message, cause, enabledSuppresion, writableStackTrace);
	}

	public ResourceNotFound(String message, Throwable cause) {
		super(message, cause);
	}

	public ResourceNotFound(Throwable cause) {
		super(cause);
	}

	public ResourceNotFound(String message) {
		super(message);
	}

}
