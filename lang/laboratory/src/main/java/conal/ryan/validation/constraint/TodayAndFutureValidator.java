package conal.ryan.validation.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import conal.ryan.validation.annotation.TodayAndFuture;
import org.joda.time.LocalDate;

/**
 * Created by cryan on 5/8/2015.
 */
public class TodayAndFutureValidator implements ConstraintValidator<TodayAndFuture, Object> {

    public void initialize(TodayAndFuture constraintAnnotation) {

    }

    public boolean isValid(Object value, ConstraintValidatorContext context) {

        boolean isValidDateRange = false;

        // Joda creates today's date when passed null
        LocalDate today = new LocalDate();
        LocalDate startDate = new LocalDate(value);

        if (startDate.isAfter(today.minusDays(1))) {
            isValidDateRange = true;
        }

        return isValidDateRange;
    }
}
