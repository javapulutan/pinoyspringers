package ph.com.pinoyspringers.validator.constraint;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckValuesValidator.class)
@Documented
public @interface CheckValues {

	String message() default "{validator.default.checkvalues}";

	Class<?>[] groups() default {};

	String[] strValues() default {};

    Class<? extends Payload>[] payload() default {};

}
