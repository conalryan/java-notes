package conal.ryan.validation.hibernate.validator;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

/**
 * Created by cryan on 5/11/2015.
 */
public class CarPropertyLevel {

    private String manufacturer;

    private boolean isRegistered;

    public CarPropertyLevel(String manufacturer, boolean isRegistered) {
        this.manufacturer = manufacturer;
        this.isRegistered = isRegistered;
    }

    @NotNull
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @AssertTrue
    public boolean isRegistered() {
        return isRegistered;
    }

    public void setRegistered(boolean isRegistered) {
        this.isRegistered = isRegistered;
    }
}
