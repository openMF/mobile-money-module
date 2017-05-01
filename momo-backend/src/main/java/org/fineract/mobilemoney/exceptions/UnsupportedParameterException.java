package org.fineract.mobilemoney.exceptions;

import java.util.List;

/**
 * A {@link RuntimeException} that is thrown in the case where invalid
 * parameters are sent in the body of the request to the API.
 */
public class UnsupportedParameterException extends RuntimeException {

	private static final long serialVersionUID = -8552519962500588686L;
	
	private final List<String> unsupportedParameters;

    
    public UnsupportedParameterException(final List<String> unsupportedParameters) {
        this.unsupportedParameters = unsupportedParameters;
    }

    public List<String> getUnsupportedParameters() {
        return this.unsupportedParameters;
    }
}