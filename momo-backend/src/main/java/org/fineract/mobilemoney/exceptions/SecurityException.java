package org.fineract.mobilemoney.exceptions;

public class SecurityException extends RuntimeException {

	private static final long serialVersionUID = -225510838617427117L;

	private SecurityException(final String msg) {
		super(msg);
	}

	public static SecurityException tenantAlreadyExists(final String tenant) {
		return new SecurityException("Tenant Already existing with "+tenant+" identifier");
	}
}
