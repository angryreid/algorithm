package emma;

import emma.fib.Fib;
import emma.time.Times;

public class Main {
    public static void testFib() {
        Fib fib = new Fib();
        int n = 30;
        Times.test("fib0", () -> {
            System.out.println(fib.fib0(n));
        });
        Times.test("fib1", () -> {
            System.out.println(fib.fib1(n));
        });

    }
    public static void main(String args[]) {
        System.out.println("Recursion");

        testFib();
    }
}
