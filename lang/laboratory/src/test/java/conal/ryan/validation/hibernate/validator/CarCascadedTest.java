package conal.ryan.validation.hibernate.validator;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by cryan on 5/11/2015.
 */
public class CarCascadedTest {

    private static Validator validator;

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testConstruction() throws Exception {

        Person person = new Person(null, 1);
        CarCascaded car = new CarCascaded("Ford", person);

        Set<ConstraintViolation<CarCascaded>> constraintViolations = validator.validate( car );

        assertEquals( 1, constraintViolations.size() );
        assertEquals("person name required", constraintViolations.iterator().next().getMessage());

        System.out.println("SIZE " + constraintViolations.size());
        System.out.println("MSG " + constraintViolations.iterator().next().getMessage());
    }

}