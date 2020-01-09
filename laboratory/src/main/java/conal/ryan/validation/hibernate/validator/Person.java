package conal.ryan.validation.hibernate.validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by cryan on 5/11/2015.
 */
public class Person {

    @NotNull(message = "person name required")
    private String name;

    @Min(value = 2)
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
