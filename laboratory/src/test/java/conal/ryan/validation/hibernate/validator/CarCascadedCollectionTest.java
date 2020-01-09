package conal.ryan.validation.hibernate.validator;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by cryan on 5/11/2015.
 */
public class CarCascadedCollectionTest {

    private static Validator validator;

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testConstruction() throws Exception {

        Person person1 = new Person("bob", 22);
        Person person2 = new Person(null, 1);

        List<Person> passengers = new ArrayList<>();
        passengers.add(person1);
        passengers.add(person2);

        CarCascadedCollection car = new CarCascadedCollection("Ford", passengers);
        Set<ConstraintViolation<CarCascadedCollection>> constraintViolations = validator.validate( car );

        assertEquals( 1, constraintViolations.size() );
        assertEquals("person name required", constraintViolations.iterator().next().getMessage());

        System.out.println("SIZE " + constraintViolations.size());
        System.out.println("MSG " +  constraintViolations.iterator().next().getMessage());
    }
}