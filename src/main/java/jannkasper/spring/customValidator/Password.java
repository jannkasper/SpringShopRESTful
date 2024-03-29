package jannkasper.spring.customValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
@Documented

public @interface Password {
    String message() default "Password is not allowed. At least 2 digits";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
