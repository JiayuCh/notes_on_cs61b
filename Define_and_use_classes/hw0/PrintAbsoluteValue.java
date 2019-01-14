public class PrintAbsoluteValue {
    public static void main(String[] args) {
        int x = args[0];

        if (x < 0)
            System.out.println("I should negate X");
            x = -x;

        System.out.println(x);
    }
}