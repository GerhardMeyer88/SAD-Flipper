package SAD;

public class sadMainTesting {
    public static void main(String[] args) {

        Object o = new String("Hello");
        print(o);
    }

    public static void print(Object o) {
        System.out.println("Hello A");
    }

    public static void print(String s) {
        System.out.println("Hello B");
    }
}
