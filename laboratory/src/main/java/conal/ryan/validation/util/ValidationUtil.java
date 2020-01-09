package conal.ryan.validation.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * Created by cryan on 4/13/2015.
 */
public class ValidationUtil {

    private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private static final Validator validator = factory.getValidator();

    // Stop instantiation
    private ValidationUtil() {
    }

    public static void validate(Object object) throws Exception {

         Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object);

        if (!constraintViolations.isEmpty()) {

            for (ConstraintViolation<Object> violation : constraintViolations) {
                String violationMessage = violation.getMessage();
                throw new Exception(violationMessage);
            }
        }
    }

    public static <T> void validate(Collection<T> list) throws Exception {

        for (T item : list) {

            Set<ConstraintViolation<T>> constraintViolations = validator.validate(item);

            if (!constraintViolations.isEmpty()) {
                System.out.println("size " + constraintViolations.size());
                for (ConstraintViolation<T> violation : constraintViolations) {
                    String violationMessage = violation.getMessage();
                    throw new Exception(violationMessage);
                }
            }
        }
    }
}
