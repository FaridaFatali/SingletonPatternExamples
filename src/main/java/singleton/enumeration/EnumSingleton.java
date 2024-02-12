package singleton.enumeration;

import java.io.Serializable;

public enum EnumSingleton implements Serializable {
    SINGLETON;

    EnumSingleton() {
        System.out.println("in EnumSingleton()");
    }

    public static EnumSingleton getInstance() {
        return SINGLETON;
    }
}
