package com.tms.validator;

import com.tms.annotations.IsAdult;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsAdultValidator implements ConstraintValidator<IsAdult, Integer> {
    @Override
    public void initialize(IsAdult constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value >= 18;
    }
}