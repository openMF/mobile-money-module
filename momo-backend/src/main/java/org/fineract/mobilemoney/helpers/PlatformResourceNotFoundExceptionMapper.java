package org.fineract.mobilemoney.helpers;

import org.fineract.mobilemoney.exceptions.AbstractPlatformResourceNotFoundException;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * The {@link AbstractPlatformResourceNotFoundException} is thrown when an api
 * call for a resource that is expected to exist does not.
 */
@Component
@Scope("singleton")
public class PlatformResourceNotFoundExceptionMapper  {

    public static ResponseEntity<ApiGlobalErrorResponse> toResponse(final AbstractPlatformResourceNotFoundException exception) {
    	final ApiGlobalErrorResponse notFoundErrorResponse = ApiGlobalErrorResponse.notFound(exception.getGlobalisationMessageCode(),
                exception.getDefaultUserMessage(), exception.getDefaultUserMessageArgs());
        return new ResponseEntity<>(notFoundErrorResponse, HttpStatus.NOT_FOUND) ;
    }
}