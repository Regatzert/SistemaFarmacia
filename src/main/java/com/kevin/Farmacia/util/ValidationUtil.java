package com.kevin.Farmacia.util;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class ValidationUtil {
    private static ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    private static Validator validator = validatorFactory.getValidator();

    public static <T> void validate(T object) {
        var violations = validator.validate(object);
        if (!violations.isEmpty()) {
            throw new RuntimeException("Validación fallida: " + violations);
        }
    }
}
