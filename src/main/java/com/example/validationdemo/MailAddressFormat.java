package com.example.validationdemo;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotBlank;
import java.lang.annotation.*;
import java.text.Format;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, FIELD})
@Constraint(validatedBy = MailAddressFormatValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface MailAddressFormat {
    String message() default "フォーマットが違います";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        MailAddressFormat[] value();
    }
}
