package conal.ryan.generics.java.generic;

/**
 * Simple generic class where T is a type paramter that will be replaced by
 * a real type when an object of type Gen is created.
 *
 * General form of generic class
 * class class-name<type-param-list> { ... }
 * class name<T1, T2, ..., Tn> { // ... }
 *
 * Create an object of the generic class
 * class-name<type-arg-list> var-name = new class-name<type-arg-list>(cons-arg-list);
 *
 * Ref: Java the Complete Reference 9th Edition p.338
 *
 * The most commonly used type parameter names are:
 * E - Element (used extensively by the Java Collections Framework)
 * K - Key
 * N - Number
 * T - Type
 * V - Value
 * S,U,V etc. - 2nd, 3rd, 4th types
 *
 * Target Types
 * The Java compiler takes advantage of target typing to infer the type parameters of a generic method invocation.
 * The target type of an expression is the data type that the Java compiler expects depending on where the expression
 * appears. Consider the method Collections.emptyList, which is declared as follows:
 *
 * static <T> List<T> emptyList();
 *
 * Created by Conal on 4/12/2015.
 */
public class GenericClass<T> {

    T t; // declare an object of type T. T stands for type

    public GenericClass(T t) { this.t = t; }

    public T getObject() { return t; }

    public void setObject(T t) { this.t = t; }

}
