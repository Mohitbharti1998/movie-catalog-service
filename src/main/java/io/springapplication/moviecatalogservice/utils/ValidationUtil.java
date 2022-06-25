package io.springapplication.moviecatalogservice.utils;

import lombok.experimental.UtilityClass;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.util.Objects;
import java.util.Set;

@UtilityClass
public class ValidationUtil {
    private static final String EMPTY_REQUEST_BODY_ERROR_MESSAGE = "Empty Request Body";

    /**
     * Applies javax validation.
     *
     * @param object           - Object to be validated.
     * @param validationGroups - Validation groups.
     */
    @SafeVarargs
    public String validateObject(final Object object, final Class<? extends Default>... validationGroups) {
        if (Objects.isNull(object)) {
            return EMPTY_REQUEST_BODY_ERROR_MESSAGE;
        }
        final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        final Set<ConstraintViolation<Object>> errors = validator.validate(object, validationGroups);
        return errors.stream().map(ConstraintViolation::getMessage).reduce("", (a, b) -> a + "\n" + b);
    }
}
