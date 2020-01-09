package conal.ryan.validation.util;

import conal.ryan.validation.hibernate.validator.CarFieldLevel;
import conal.ryan.validation.hibernate.validator.Person;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cryan on 4/13/2015.
 */
public class ValidationUtilTest {

    private CarFieldLevel car;
    private CarFieldLevel carError;
    private List<CarFieldLevel> carList;

    @Before
    public void setup() {
        car = new CarFieldLevel("BMW", "AA-BC-789", 2);
        carError = new CarFieldLevel( null, "DD-AB-123", 4 );
        carList = new ArrayList<>();
        carList.add(car);
        carList.add(carError);
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();


    @Test
    public void testValidate() throws Exception {
        // Shouldn't produce errors/violations
        ValidationUtil.validate(car);
    }

    @Test
    public void testValidate2() throws Exception {
        // Error/validation violation expected
        exception.expect(Exception.class);
        ValidationUtil.validate(carError);
    }

    @Test
    public void testValidateCollection() throws Exception {
        // Error/validation violation expected
        exception.expect(Exception.class);
        ValidationUtil.validate(carList);
    }

    @Test
    public void testValidateCollection2() throws Exception {

        Person person1 = new Person(null, 22);
        Person person2 = new Person(null, 1);
        List<Person> personList = new ArrayList<>();
        personList.add(person1);
        personList.add(person2);

        // Error/validation violation expected
        exception.expect(Exception.class);
        ValidationUtil.validate(personList);
    }
}
