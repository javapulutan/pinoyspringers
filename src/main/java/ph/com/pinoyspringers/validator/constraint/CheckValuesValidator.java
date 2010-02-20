package ph.com.pinoyspringers.validator.constraint;

import java.util.Arrays;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 
 * @author JSEE
 * 
 */
public class CheckValuesValidator implements
		ConstraintValidator<CheckValues, String> {

	private CheckValues checkValues;

	@Override
	public void initialize(CheckValues constraintValues) {

		this.checkValues = constraintValues;

	}

	@Override
	public boolean isValid(String object, ConstraintValidatorContext context) {

		return (object == null) ? true : Arrays.asList(checkValues.strValues())
				.contains(object);

	}
}
