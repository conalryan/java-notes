package conal.ryan.reflection.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.*;

import static java.lang.System.out;

/**
 * The ClassDeclarationSpy example shows how to obtain the declaration components of a class including the
 * modifiers,
 * generic type parameters,
 * implemented interfaces,
 * inheritance path,
 * runtime annotations.
 *
 * Ref: https://docs.oracle.com/javase/tutorial/reflect/class/classModifiers.html
 *
 * Created by Conal on 4/9/2015.
 */
public class ClassDeclarationUtil {

    private static String typeVariableString;
    private static String interfaceString;
    private static String inheritanceString;
    private static String annotationString;

    public static Map<String, Collection<?>> getClassDeclaration(String className) {

        Map<String, Collection<?>> classDeclarationMap = new HashMap<String, Collection<?>>();
        List<String> classInfoList = new ArrayList<String>();

        try {
            Class<?> clazz = Class.forName(className);
            String canoicalName = clazz.getCanonicalName();
            String modifiers = Modifier.toString(clazz.getModifiers());

            // add class info to list
            classInfoList.add(clazz.getSimpleName());
            classInfoList.add(canoicalName);
            classInfoList.add(modifiers);

            // add list to hashmap
            classDeclarationMap.put("ClassDeclaration", classInfoList);

            // Type Parameters
            TypeVariable[] typeVariables = clazz.getTypeParameters();
            List<TypeVariable> typeList = new ArrayList<TypeVariable>();

            if (typeVariables.length != 0) {
                for (TypeVariable typeVariable : typeVariables) {
                    typeVariableString = typeVariable.getName();
                    typeList.add(typeVariable);
                }
            }

            classDeclarationMap.put("TypeVariable", typeList);

/*
            // Type Parameters
            TypeVariable[] typeVariables = clazz.getTypeParameters();
            classDeclarationMap.put("typeVariable", Arrays.asList(typeVariables));

            //classDeclarationMap.put("TypeVariable", Arrays.asList(typeVariables));

            if (typeVariables.length != 0) {
                for (TypeVariable typeVariable : typeVariables)
                    typeVariableString = typeVariable.getName();
            }
*/
            // Implemented Interfaces
            Type[] interfacess = clazz.getGenericInterfaces();
            classDeclarationMap.put("Interfaces", Arrays.asList(interfacess));

            if (interfacess.length != 0) {
                for (Type intferace : interfacess)
                    interfaceString = intferace.toString();
            }

            // Inheritance
            List<Class> list = new ArrayList<Class>();
            classDeclarationMap.put("Inheritance", Arrays.asList(list));

            if (list.size() != 0) {
                for (Class<?> clazz1 : list)
                    inheritanceString = clazz1.getCanonicalName();
            }

            // Annotations
            Annotation[] annotations = clazz.getAnnotations();
            classDeclarationMap.put("Annotation", Arrays.asList(annotations));

            if (annotations.length != 0) {
                for (Annotation annotation : annotations)
                    annotationString = annotation.toString();
            }

            // production code should handle this exception more gracefully
        } catch (ClassNotFoundException x) {
            x.printStackTrace();
        }
        return classDeclarationMap;
    }

    /*private static void getAncestor(Class<?> c, List<Class> list) {
        Class<?> ancestor = c.getSuperclass();
        if (ancestor != null) {
            list.add(ancestor);
            printAncestor(ancestor, list);
        }
    }*/
}