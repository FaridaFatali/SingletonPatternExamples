package singleton;

public class BillPughSingleton {
    private static int count;
    private String name;

    private BillPughSingleton() {
        name = "BillPughSingleton" + count;
        count++;
    }

    public String getName() {
        return name;
    }

    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public void printName() {
        System.out.println(name);
    }

    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
