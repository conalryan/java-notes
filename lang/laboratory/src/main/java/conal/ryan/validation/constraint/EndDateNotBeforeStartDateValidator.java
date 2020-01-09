package conal.ryan.validation.constraint;

import java.lang.reflect.InvocationTargetException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import conal.ryan.validation.annotation.EndDateNotBeforeStartDate;
import org.apache.commons.beanutils.BeanUtils;
//import org.apache.log4j.Logger;
import org.joda.time.LocalDate;

public class EndDateNotBeforeStartDateValidator implements ConstraintValidator<EndDateNotBeforeStartDate, Object> {

    private String firstFieldName;
    private String secondFieldName;
   // private static final Logger LOG = Logger.getLogger(EndDateNotBeforeStartDate.class);

    @Override
    public void initialize(final EndDateNotBeforeStartDate constraintAnnotation) {

        firstFieldName = constraintAnnotation.firstDate();
        secondFieldName = constraintAnnotation.secondDate();
    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext constraintContext) {

        String startDateString = null;
        String endDateString = null;

        try {
            // Get values from fields
            startDateString = BeanUtils.getProperty(value, firstFieldName);
            endDateString = BeanUtils.getProperty(value, secondFieldName);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
           // LOG.debug("Error getting date fields " + e.getCause());
            return false;
        }

        // Joda creates today's date when passed null
        // convert string to joda date
        LocalDate startDate = new LocalDate(startDateString);
        LocalDate endDate = new LocalDate(endDateString);

        return endDate.isAfter(startDate.minusDays(1));
    }
}
