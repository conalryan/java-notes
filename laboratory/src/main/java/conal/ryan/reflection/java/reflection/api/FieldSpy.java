package conal.ryan.reflection.java.reflection.api;

import java.lang.reflect.Field;
import java.util.List;

/**
 * The FieldSpy example prints the field's type and generic type given a fully-qualified binary class name and field name.
 *
 * Ref: https://docs.oracle.com/javase/tutorial/reflect/member/fieldTypes.html
 *
 * Created by Conal on 4/9/2015.
 */
public class FieldSpy<T> {
    public boolean[][] b = {{ false, false }, { true, true } };
    public String name  = "Alice";
    public List<Integer> list;
    public T val;

    public static void main(String... args) {
        try {
            Class<?> c = Class.forName(args[0]);
            Field f = c.getField(args[1]);
            System.out.format("Type: %s%n", f.getType());
            System.out.format("GenericType: %s%n", f.getGenericType());

            // production code should handle these exceptions more gracefully
        } catch (ClassNotFoundException x) {
            x.printStackTrace();
        } catch (NoSuchFieldException x) {
            x.printStackTrace();
        }
    }
}
