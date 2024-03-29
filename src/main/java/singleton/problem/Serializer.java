package singleton.problem;

import java.io.*;

public class Serializer {
    public static <T> T deserializeToObject(Class<T> clazz, String filePath) {
        T o = null;
        try (FileInputStream fileIn = new FileInputStream(filePath);
        ObjectInputStream in = new ObjectInputStream(fileIn)) {
            o = (T) in.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return o;
    }

    public static void serializeToFile(Object o, String filePath) {
        try (FileOutputStream fileOut = new FileOutputStream(filePath); ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(o);
            System.out.printf("Serialized data is saved in " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void print(Serializable singleton) {
        String msg = String.format("\nSingleton HashCode = %s", singleton.hashCode());
        System.out.println(msg);
    }
}
