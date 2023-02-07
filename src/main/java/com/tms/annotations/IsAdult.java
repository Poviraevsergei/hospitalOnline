package com.tms.annotations;

import com.tms.validator.IsAdultValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = IsAdultValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IsAdult {
    String message() default "Go to school!Puppy!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
