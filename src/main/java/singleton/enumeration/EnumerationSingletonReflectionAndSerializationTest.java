package singleton.enumeration;

import singleton.problem.Serializer;
import java.lang.reflect.Constructor;

public class EnumerationSingletonReflectionAndSerializationTest {
    public static void main(String[] args) {
        checkReflection();
        checkSerialization();
    }

    public static void checkReflection() {
        Class<EnumSingleton> singletonClass = EnumSingleton.class;
        Constructor<EnumSingleton> defaultConstructor = null;
        try {
            defaultConstructor = singletonClass.getDeclaredConstructor(null);
            System.out.println("Default constructor: " + defaultConstructor);
        } catch (SecurityException e) {
            System.out.println("Problem with security: " + e.getMessage());
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            System.out.println(e);
            System.out.println("Problem with getting default constructor: " + e.getMessage());
        }

        System.out.println("Name: " + defaultConstructor.getName());  // NullPointeException because defaultConstructor object does not exist!
        System.out.println("Modifier: " + defaultConstructor.getModifiers());
        System.out.println("Is accessible: " + defaultConstructor.isAccessible());
        defaultConstructor.setAccessible(true);
        System.out.println("Modifier: " + defaultConstructor.getModifiers());
        System.out.println("Is accessible: " + defaultConstructor.isAccessible());

        EnumSingleton secondSingleton = null;
        EnumSingleton thirdSingleton = null;
    }

    public static void checkSerialization() {
        EnumSingleton singleton1 = EnumSingleton.SINGLETON;

        String filePath = "C:\\Users\\User\\Desktop\\singleton.ser";
        Serializer.serializeToFile(singleton1, filePath);

        EnumSingleton singleton2 = Serializer.deserializeToObject(EnumSingleton.class, filePath);

        System.out.println();

        if (singleton1 == singleton2) {
            System.out.println("2 instances are equal.");
        } else {
            System.out.println("2 instances are NOT equal.");
        }

        Serializer.print(singleton1);
        Serializer.print(singleton2);
    }
}
