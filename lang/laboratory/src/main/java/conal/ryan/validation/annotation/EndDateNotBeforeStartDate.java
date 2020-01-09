package conal.ryan.validation.annotation;

import conal.ryan.validation.constraint.EndDateNotBeforeStartDateValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import static java.lang.annotation.ElementType.*;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;

/**
 * Validation annotation to validate that end date is the same as the start date or later.
 *
 * * Supported types are:
 * <ul>
 *     <li>{@code java.lang.String}</li>
 * </ul>
 * <p/>
 * {@code null} elements are considered valid.
 * 
 * Example, compare 1 pair of fields:
 * @EndDateNotBeforeStartDate(firstDate = "startDate", secondDate = "endDate", message = "End date cannot be before the start date")
 *
 */
@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = EndDateNotBeforeStartDateValidator.class)
@Documented
public @interface EndDateNotBeforeStartDate {
	
    String message();

    // groups() and payload() are required for custom annotations
    // Ref http://docs.jboss.org/hibernate/validator/5.0/reference/en-US/html_single/#validator-customconstraints
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    /**
     * @return The first field
     */
    String firstDate();

    /**
     * @return The second field
     */
    String secondDate();
}
