package com.web.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by ivan on 15-1-22.
 */
public class NotEmptyValidator implements ConstraintValidator<NotEmpty,String> {
    @Override
    public void initialize(NotEmpty constraintAnnotation) { }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null) return false;
        if("".equals(value.trim())) return false;
        return true;
    }
}
