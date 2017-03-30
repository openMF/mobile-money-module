package org.fineract.mobilemoney.helpers;

import org.fineract.mobilemoney.exceptions.PlatformApiDataValidationException;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * The {@link PlatformApiDataValidationException} is typically thrown in data
 * validation of the parameters passed in with an API request.
 */
@Component
@Scope("singleton")
public class PlatformApiDataValidationExceptionMapper {

    public static ResponseEntity<ApiGlobalErrorResponse> toResponse(final PlatformApiDataValidationException exception) {
        final ApiGlobalErrorResponse dataValidationErrorResponse = ApiGlobalErrorResponse.badClientRequest(
                exception.getGlobalisationMessageCode(), exception.getDefaultUserMessage(), exception.getErrors());
        return new ResponseEntity<>(dataValidationErrorResponse, HttpStatus.BAD_REQUEST) ;
    }
}