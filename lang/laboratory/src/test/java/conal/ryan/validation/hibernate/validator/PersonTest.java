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
public class PersonTest {

    private static Validator validator;

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testConstruction() throws Exception {

        String name = null;
        Person person = new Person(null, 22);
        Person person2 = new Person(name, 1);

        assertNotNull("may not be null", person); // this passes, it doesn't catch the name is null
        //assertNotNull("name not null", person.getName()); // this throws error since the name is null

        assertNotNull("may not be null", person2); // this passes, it doesn't catch the name is null
        //assertNotNull("name not null", person2.getName()); // this throws error since the name is null

    }

    @Test
    public void testHibernateValidator() throws Exception {

        Person person = new Person(null, 1);

        Set<ConstraintViolation<Person>> constraintViolations = validator.validate( person );

        assertEquals( 1, constraintViolations.size() );
        assertEquals("person name required", constraintViolations.iterator().next().getMessage());

        System.out.println("SIZE " + constraintViolations.size());
        System.out.println("MSG " +  constraintViolations.iterator().next().getMessage());
    }
}