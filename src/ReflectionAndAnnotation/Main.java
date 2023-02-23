package ReflectionAndAnnotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Reflection> clazz = Reflection.class;
        Method[] methods = clazz.getDeclaredMethods();
        TreeSet<Method> getters = filterMethodsBy(methods, "get");
        TreeSet<Method> setters = filterMethodsBy(methods, "set");
        getters.stream().forEach(m -> {
            System.out.printf("%s will return %s\n", m.getName(), m.getReturnType());
        });
        setters.stream().forEach((method -> {
            System.out.printf("%s and will set field of %s\n", method.getName(), method.getAnnotatedParameterTypes());
        }));
    }

    public static TreeSet<Method> filterMethodsBy(Method[] methods, String filter) {
        return Arrays.stream(methods).filter(m -> m.getName().contains(filter))
                .collect(Collectors.toCollection(()
                        -> new TreeSet<>(Comparator.comparing(Method::getName))));

    }

}
