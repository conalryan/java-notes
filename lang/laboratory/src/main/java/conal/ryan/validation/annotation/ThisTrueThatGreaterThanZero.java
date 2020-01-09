package conal.ryan.validation.annotation;

import conal.ryan.validation.constraint.ThisTrueThatGreaterThanZeroValidator;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Validation annotation to validate a field is required depending on another
 *
 * * <p/>
 * Supported types are:
 * <ul>
 * 	   <li>{@code java.lang.boolean}</li>
 *     <li>{@code java.lang.integer}</li>
 * </ul>
 * <p/>
 * {@code null} elements are considered valid.
 * 
 * Example, compare 1 pair of fields:
 * @ThisTrueThatGreaterThanZeroValidator(boolField = "isCxlNoShow", intField = "daysPriorToArrival", message = "this is required for that")
 * 
 */
@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = ThisTrueThatGreaterThanZeroValidator.class)
@Documented
public @interface ThisTrueThatGreaterThanZero {
	
    String message();

    // groups() and payload() are required for custom annotations
    // Ref http://docs.jboss.org/hibernate/validator/5.0/reference/en-US/html_single/#validator-customconstraints
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    /**
     * @return The boolean field
     */
    String boolField();

    /**
     * @return The integer field
     */
    String intField();
}
