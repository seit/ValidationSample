package com.example.validationdemo;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MailAddressFormatValidator implements ConstraintValidator<MailAddressFormat, MailAddress> {

    @Override
    public boolean isValid(MailAddress value, ConstraintValidatorContext context) {
        if(value.getText().isEmpty()) return true;
        return value.getText().contains("@");
    }
}
