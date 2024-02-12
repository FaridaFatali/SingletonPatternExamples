package singleton.problem;

import singleton.Singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SingletonReflectionClient {
    public static void main(String[] args) {
        Class<Singleton> singletonClass = Singleton.class;
        Constructor<Singleton> defaultConstructor = null;
        try {
            defaultConstructor = singletonClass.getDeclaredConstructor(null);
        } catch (SecurityException e) {
            System.out.println("Problem with security: " + e.getMessage());
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            System.out.println("Problem with calling method: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("Name: " + defaultConstructor.getName());
        System.out.println("Modifier: " + defaultConstructor.getModifiers());
        System.out.println("Is accessible: " + defaultConstructor.isAccessible());
        defaultConstructor.setAccessible(true);
        System.out.println("Modifier: " + defaultConstructor.getModifiers());
        System.out.println("Is accessible: " + defaultConstructor.isAccessible());

        Singleton newSingleton;

        System.out.println("\nCreating new singleton objects:");
        try {
            for (int i = 0; i < 100; i++) {
                newSingleton = defaultConstructor.newInstance((Object) null);
                newSingleton.printName();
            }
        } catch (IllegalArgumentException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            e.printStackTrace();
        }

        Singleton anotherSingleton = null;
        Singleton yetAnotherSingleton = null;

        try {
            anotherSingleton = defaultConstructor.newInstance((Object) null);
            yetAnotherSingleton = defaultConstructor.newInstance((Object) null);
        } catch (IllegalArgumentException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            e.printStackTrace();
        }

        if (anotherSingleton == yetAnotherSingleton) {
            System.out.println("\nThe same object!");
        } else {
            System.out.println("\nDifferent object!");
        }

//        Method[] methods = singletonClass.getMethods();
//        for (Method m : methods) {
//            System.out.println(m.getName());
//            if (m.getName().equals("toString")) {
//                try {
//                    Object o = m.invoke(secondSingleton, null);
//                    System.out.println(o);
//                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
    }
}
