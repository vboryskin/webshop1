package com.vboryskin.webshop1.validator;


import org.springframework.stereotype.Controller;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Constraint(validatedBy = UserValidator.class)
public @interface RegistrationValid {
    String message() default "Invalid User Information";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
