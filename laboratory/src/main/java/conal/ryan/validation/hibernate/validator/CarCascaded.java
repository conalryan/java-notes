package conal.ryan.validation.hibernate.validator;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by cryan on 5/11/2015.
 */
public class CarCascaded {

    @NotNull(message = "car make is required")
    private String carMake = "Ford";

    @NotNull(message = "driver required")
    @Valid
    private Person driver;

    public CarCascaded(String carMake, Person driver) {
        this.carMake = carMake;
        this.driver = driver;
    }

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public Person getDriver() {
        return driver;
    }

    public void setDriver(Person driver) {
        this.driver = driver;
    }
}
