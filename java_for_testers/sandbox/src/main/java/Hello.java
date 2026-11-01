public class Hello {
    static void main(String[] args) throws Exception {
        int a = 1;
        int b = 1;
        if(a ==0 || b == 0 ){
            System.out.println("Division by zero is not allowed");
        } else {
            int c = divide(a, b);
            System.out.println("Hello world!");
        }
    }

    private static int divide(int a, int b) {
            int c = a / b;
            return c;
    }
}
