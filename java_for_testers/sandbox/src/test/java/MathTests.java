import org.junit.jupiter.api.Test;

public class MathTests {

    @Test
    void divideByZero() {
        int a = 1;
        int b = 0;
        int c = a/b;
        System.out.println(c);
    }
}
