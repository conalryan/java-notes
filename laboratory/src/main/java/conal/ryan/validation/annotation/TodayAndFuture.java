package conal.ryan.validation.annotation;

import conal.ryan.validation.constraint.TodayAndFutureValidator;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


/**
 * The annotated element must be a string date that is today or in the future.
 * Now is defined as the current local time according to the virtual machine
 * <p/>
 * Supported types are:
 * <ul>
 *     <li>{@code java.lang.String}</li>
 * </ul>
 * <p/>
 * {@code null} elements are considered valid.
 */
@Target({ FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = TodayAndFutureValidator.class)
public @interface TodayAndFuture {

    String message();

    // groups() and payload() are required for custom annotations
    // Ref http://docs.jboss.org/hibernate/validator/5.0/reference/en-US/html_single/#validator-customconstraints
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}