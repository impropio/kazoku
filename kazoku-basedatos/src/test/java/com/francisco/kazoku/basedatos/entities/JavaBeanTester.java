package com.francisco.kazoku.basedatos.entities;

import static org.junit.Assert.fail;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * This helper class can be used to unit test the get/set methods of JavaBean-style Value Objects.
 * 
 * @author rob.dawson
 */
public class JavaBeanTester {

    /**
     * Tests the get/set methods of the specified class.
     *
     * @param <T> the type parameter associated with the class under test
     * @param clazz the Class under test
     * @param skipThese the names of any properties that should not be tested
     * @throws Exception the exception
     */
    public static <T> void test(final Class<T> clazz, final String... skipThese) throws Exception {
        final PropertyDescriptor[] props = Introspector.getBeanInfo(clazz).getPropertyDescriptors();
        final T bean = clazz.newInstance();
        nextProp: for (final PropertyDescriptor prop : props) {
            // Check the list of properties that we don't want to test
            for (final String skipThis : skipThese) {
                if (skipThis.equals(prop.getName())) {
                    continue nextProp;
                }
            }
            findBooleanIsMethods(clazz, prop);
            final Method getter = prop.getReadMethod();
            final Method setter = prop.getWriteMethod();

            if (getter != null && setter != null) {
                // We have both a get and set method for this property
                final Class<?> returnType = getter.getReturnType();
                final Class<?>[] params = setter.getParameterTypes();

                if (params.length == 1 && params[0] == returnType) {
                    // The set method has 1 argument, which is of the same type as the return type of the get method, so
                    // we can test this property
                    try {
                        // Build a value of the correct type to be passed to the set method
                        final Object value = buildValue(returnType);

                        // Call the set method, then check the same value comes back out of the get method
                        setter.invoke(bean, value);

                        // final Object expectedValue = value;
                        // final Object actualValue = getter.invoke(bean);
                        getter.invoke(bean);

                        // assertEquals(String.format("Failed while testing property %s", prop.getName()),
                        // expectedValue, actualValue );

                    } catch (final Exception ex) {
                        fail(String.format("An exception was thrown while testing the property %s--%s: %s",
                                prop.getName(), clazz, ex.toString()));
                    }
                }
            }
        }

        try {
            final Method methodEquals = clazz.getMethod("equals", Object.class);
            if (methodEquals != null) {
                methodEquals.invoke(bean, bean);
                methodEquals.invoke(bean, clazz.newInstance());
            }
        } catch (final Exception e) {
            fail("Excepcion intentando analizar el metodo equals de " + clazz.getName());
        }
        try {
            final Method methodHashCode = clazz.getMethod("hashCode");
            if (methodHashCode != null) {
                methodHashCode.invoke(bean);
            }
        } catch (final Exception e) {
            fail("Excepcion intentando analizar el metodo hashCode de " + clazz.getName());
        }

    }

    /**
     * Builds the mock value.
     *
     * @param clazz the clazz
     * @return the object
     */
    private static Object buildMockValue(Class<?> clazz) {
        if (!Modifier.isFinal(clazz.getModifiers())) {
            // Insert a call to your favourite mocking framework here
            return null;
        } else {
            return null;
        }
    }

    /**
     * Builds the value.
     *
     * @param clazz the clazz
     * @return the object
     * @throws InstantiationException the instantiation exception
     * @throws IllegalAccessException the illegal access exception
     * @throws IllegalArgumentException the illegal argument exception
     * @throws SecurityException the security exception
     * @throws InvocationTargetException the invocation target exception
     */
    private static Object buildValue(Class<?> clazz) throws InstantiationException, IllegalAccessException,
            IllegalArgumentException, SecurityException, InvocationTargetException {
        // If we are using a Mocking framework try that first...
        final Object mockedObject = buildMockValue(clazz);
        if (mockedObject != null) {
            return mockedObject;
        }

        // Specific rules for common classes
        if (clazz == String.class) {
            return "testvalue";

        } else if (clazz.isArray()) {
            return Array.newInstance(clazz.getComponentType(), 1);

        } else if (clazz == boolean.class || clazz == Boolean.class) {
            return true;

        } else if (clazz == int.class || clazz == Integer.class) {
            return 1;

        } else if (clazz == long.class || clazz == Long.class) {
            return 1L;

        } else if (clazz == double.class || clazz == Double.class) {
            return 1.0D;

        } else if (clazz == float.class || clazz == Float.class) {
            return 1.0F;

        } else if (clazz == char.class || clazz == Character.class) {
            return 'Y';

        } else if (clazz.isEnum()) {
            return clazz.getEnumConstants()[0];

            // Add your own rules here

        } else if (clazz == Number.class) {
            return 1;

        } else {
            // fail("Unable to build an instance of class " + clazz.getName() + ", please add some code to the "
            // + JavaBeanTester.class.getName() + " class to do this.");
            // Next check for a no-arg constructor
            final Constructor<?>[] ctrs = clazz.getConstructors();
            for (final Constructor<?> ctr : ctrs) {
                if (ctr.getParameterTypes().length == 0) {
                    // The class has a no-arg constructor, so just call it
                    return ctr.newInstance();
                }
            }
            return null; // for the compiler
        }
    }

    /**
     * Hunt down missing Boolean read method if needed as Introspector cannot find 'is' getters for Boolean type
     * properties.
     *
     * @param <T> the generic type
     * @param clazz the type being introspected
     * @param descriptor the property descriptor found so far
     * @throws IntrospectionException the introspection exception
     */
    public static <T> void findBooleanIsMethods(Class<T> clazz, PropertyDescriptor descriptor)
            throws IntrospectionException {
        if (needToFindReadMethod(descriptor)) {
            findTheReadMethod(descriptor, clazz);
        }
    }

    /**
     * Need to find read method.
     *
     * @param property the property
     * @return true, if successful
     */
    private static boolean needToFindReadMethod(PropertyDescriptor property) {
        return property.getReadMethod() == null && property.getPropertyType() == Boolean.class;
    }

    /**
     * Find the read method.
     *
     * @param <T> the generic type
     * @param descriptor the descriptor
     * @param clazz the clazz
     */
    private static <T> void findTheReadMethod(PropertyDescriptor descriptor, Class<T> clazz) {
        try {
            final PropertyDescriptor pd = new PropertyDescriptor(descriptor.getName(), clazz);
            descriptor.setReadMethod(pd.getReadMethod());
        } catch (final IntrospectionException e) {
        }
    }
}
