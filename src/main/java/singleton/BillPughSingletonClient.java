package singleton;

public class BillPughSingletonClient extends Thread{
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {  // creates 100 times the same object
            new BillPughSingletonClient().start();
        }
    }

    public void run() {
        BillPughSingleton ls = BillPughSingleton.getInstance();
        ls.printName();
    }
}
