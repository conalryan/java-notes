package conal.ryan.generic.java.generic;

import conal.ryan.generics.java.generic.GenericClass;
import conal.ryan.validation.hibernate.validator.CarFieldLevel;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by cryan on 4/13/2015.
 */
public class GenericClassTest {

    private CarFieldLevel car;
    private GenericClass<CarFieldLevel> carGeneric;

    @Before
    public void setup() {
        car = new CarFieldLevel("Audi", "CC-DD-22", 4);
        carGeneric = new GenericClass<>(car);
    }

    @Test
    public void objectCreationTest() {
        assertFalse("Objects are equal should be false", car.getClass().equals(carGeneric.getClass()));
    }
}
