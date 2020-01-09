package conal.ryan.validation.hibernate.validator;

import org.junit.BeforeClass;

import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cryan on 5/11/2015.
 */
public class CarCascadedCollection {

    @NotNull(message = "car make is required")
    private String make;

    @NotNull(message = "passengers required")
    @Valid
    private List<Person> passengers = new ArrayList<Person>();

    public CarCascadedCollection(String name, List<Person> passengers) {
        this.make = name;
        this.passengers = passengers;
    }

    public String getName() {
        return make;
    }

    public void setName(String name) {
        this.make = name;
    }

    public List<Person> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Person> passengers) {
        this.passengers = passengers;
    }
}
