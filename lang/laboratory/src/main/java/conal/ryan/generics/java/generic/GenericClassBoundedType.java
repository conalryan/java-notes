package conal.ryan.generics.java.generic;

/**
 * Class must be the specified extended class or a subtype thereof
 * Can also specify interfaces with classes.  Class must be listed first.
 * To specify multiple interfaces use &
 * class Gen<T extends MyClass & MyInterface> { // ...
 *
 * Ref: Java Complete Reference 9th edition p.346
 *
 * Created by Conal on 4/12/2015.
 */
public class GenericClassBoundedType<T extends Number> {

    T[] nums; // array of Number or subclass

    public GenericClassBoundedType(T[] object) {
        this.nums = object;
    }

    public T[] getNums() {
        return nums;
    }

    public void setNums(T[] nums) {
        this.nums = nums;
    }

    double average() {
        double sum = 0.0;

        for(int i = 0; i < nums.length; i++)
            sum += nums[i].doubleValue();

        return sum / nums.length;
    }

    // use wildcard to compare different unknown types
    // T won't work unless both objects are the same ie. both are Integer
    boolean sameAverage(GenericClassBoundedType<?> ob) {
        if(average() == ob.average())
            return true;

        return false;
    }

    // Generic Method
    // must specify generic return type
    public <U extends Number> void inspect(U u){
        System.out.println("T: " + nums.getClass().getName());
        System.out.println("U: " + u.getClass().getName());
    }
}