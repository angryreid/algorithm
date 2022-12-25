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
        Times.test("fib2", () -> {
            System.out.println(fib.fib2(n));
        });
        Times.test("fib3", () -> {
            System.out.println(fib.fib3(n));
        });
        Times.test("fib4", () -> {
            System.out.println(fib.fib4(n));
        });
    }

    public static void testClimbStairs() {
        Fib fib = new Fib();

        Times.test("testClimbStairs", () -> {
            System.out.println(fib.climbStairs2(3));
        });
    }

    public static void main(String args[]) {
        System.out.println("Recursion");

//        testFib();
        testClimbStairs();
    }
}
