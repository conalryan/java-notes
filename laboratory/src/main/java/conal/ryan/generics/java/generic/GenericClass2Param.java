package conal.ryan.generics.java.generic;

/**
 * Declare multiple paramters with a comma separated list.
 * Ref: Complete Java Reference 9th edition. p. 344
 *
 * Created by Conal on 4/12/2015.
 */
public class GenericClass2Param<T, V> {

        T ojbect1;
        V object2;

    public GenericClass2Param(T ojbect1, V object2) {
        this.ojbect1 = ojbect1;
        this.object2 = object2;
    }

    public T getOjbect1() {
        return ojbect1;
    }

    public void setOjbect1(T ojbect1) {
        this.ojbect1 = ojbect1;
    }

    public V getObject2() {
        return object2;
    }

    public void setObject2(V object2) {
        this.object2 = object2;
    }
}
