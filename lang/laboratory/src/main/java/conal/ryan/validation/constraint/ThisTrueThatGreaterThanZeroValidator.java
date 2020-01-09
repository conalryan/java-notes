package conal.ryan.validation.constraint;

import java.lang.reflect.InvocationTargetException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import conal.ryan.validation.annotation.ThisTrueThatGreaterThanZero;
import org.apache.commons.beanutils.PropertyUtils;
//import org.apache.log4j.Logger;


public class ThisTrueThatGreaterThanZeroValidator implements ConstraintValidator<ThisTrueThatGreaterThanZero, Object> {
    
    private String booleanFieldName;
    private String integerFieldName;
    //private static final Logger LOG = Logger.getLogger(ThisTrueThatGreaterThanZeroValidator.class);

    public void initialize(final ThisTrueThatGreaterThanZero constraintAnnotation) {
         
    	booleanFieldName = constraintAnnotation.boolField();
    	integerFieldName = constraintAnnotation.intField();
    }
 
    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext constraintContext) {
         
    	if(value == null) {
    		return true; // use @NotNull for null checks
    	}
    	
        boolean thisBool;
        int thatInt;
         
        /* 	Get fields in different try blocks to handle null pointer exceptions
        	distinctly for each field */
        try {
           	thisBool = (boolean) PropertyUtils.getProperty(value, booleanFieldName);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
        	//LOG.debug("Error getting boolean field " + e.getCause());
            return false;
        } catch (NullPointerException e) {
        	return true; // use @NotNull for null checks. If bool is null than int field isn't required
        }
        
        try {
        	thatInt =  (int) PropertyUtils.getProperty(value, integerFieldName);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
        	//LOG.debug("Error getting number field " + e.getCause());
            return false;
        } catch (NullPointerException e) {
        	if (thisBool) {
        		return false; // bool is true and int is null. It should be greater than zero
        	} else {
        		return true; // both are null, int is not required
        	}
        }
        return thatInt > 0;
    }
}