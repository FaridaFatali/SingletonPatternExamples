package singleton.problem;

import java.io.Serial;
import java.io.Serializable;

public class SingletonTrueSerializable implements Serializable {
    private static int count;
    private String name;

    private SingletonTrueSerializable() {
        name = "PughSingleton" + count;
        count++;
    }

    public String getName() {
        return name;
    }

    private static class SingletonHelper {
        private static final SingletonTrueSerializable INSTANCE = new SingletonTrueSerializable();
    }

    public void printName() {
        System.out.println(name);
    }

    public static SingletonTrueSerializable getInstance() {
        return SingletonHelper.INSTANCE;
    }

    @Serial
    protected Object readResolve() {
        return getInstance();
    }
}
