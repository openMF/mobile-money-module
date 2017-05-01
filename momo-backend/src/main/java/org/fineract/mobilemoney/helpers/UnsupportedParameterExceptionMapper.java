package org.fineract.mobilemoney.helpers;

import java.util.ArrayList;
import java.util.List;

import org.fineract.mobilemoney.exceptions.UnsupportedParameterException;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class UnsupportedParameterExceptionMapper  {

    public static ResponseEntity<ApiGlobalErrorResponse> toResponse(final UnsupportedParameterException exception) {
        final List<ApiParameterError> errors = new ArrayList<>();
        for (final String parameterName : exception.getUnsupportedParameters()) {
            final StringBuilder validationErrorCode = new StringBuilder("error.msg.parameter.unsupported");
            final StringBuilder defaultEnglishMessage = new StringBuilder("The parameter ").append(parameterName).append(
                    " is not supported.");
            final ApiParameterError error = ApiParameterError.parameterError(validationErrorCode.toString(),
                    defaultEnglishMessage.toString(), parameterName, parameterName);

            errors.add(error);
        }

        final ApiGlobalErrorResponse invalidParameterError = ApiGlobalErrorResponse.badClientRequest(
                "validation.msg.validation.errors.exist", "Validation errors exist.", errors);
        return new ResponseEntity<>(invalidParameterError, HttpStatus.BAD_REQUEST) ;
    }
}