package singleton.usage;

import java.awt.*;
import java.util.Map;
import java.io.Console;
import java.util.Properties;

public class SingletonInJavaAPI {
    public static void main(String[] args) {
        Runtime rt1 = Runtime.getRuntime();
        Runtime rt2 = Runtime.getRuntime();
        if (rt1 == rt2) {
            message();
        }

        Desktop d1 = Desktop.getDesktop();
        Desktop d2 = Desktop.getDesktop();
        if (d1 == d2) {
            message();
        }

//        SecurityManager sm1 = System.getSecurityManager();
//        SecurityManager sm2 = System.getSecurityManager();
//        if (sm1 == sm2) {
//            message();
//        }

        Console cons1 = System.console();
        Console cons2 = System.console();
        if (cons1 == cons2) {
            message();
        }

        Properties props1 = System.getProperties();
        Properties props2 = System.getProperties();
        if (props1 == props2) {
            message();
        }

        Map map1 = System.getenv();
        Map map2 = System.getenv();
        if (map1 == map2) {
            message();
        }
    }

    private static void message() {
        System.out.println("It's a singleton!");
    }

}
