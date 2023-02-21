package emma;

import emma.fib.Fib;
import emma.hanoi.Hanoi;
import emma.time.Times;

import java.util.Stack;

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

    public static void testHanoi() {
        Hanoi hanoi = new Hanoi();
        Times.test("testHanoi", () -> {
           hanoi.hanoi(3, "A", "B", "C");
        });
    }

    public static void log(int n) {
        if (n < 1) return;
        log(n - 1);
        int v = n + 10;
        System.out.println(v);
    }

    public static class Frame {
        int n;
        int v;
        Frame(int n, int v) {
            this.n = n;
            this.v = v;
        }
    }

    public static void logStack(int n) {
        Stack<Frame> frames = new Stack<>();
        while (n > 0) {
            frames.push(new Frame(n, n + 10));
            n--;
        }

        while(!frames.isEmpty()) {
            System.out.println(frames.pop().v);
        }
    }

    public static void logLite(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println(i + 10);
        }
    }

    public static void main(String args[]) {
        System.out.println("Recursion");

//        testFib();
//        testClimbStairs();
//        testHanoi();
        log(4);
        logStack(4);
        logLite(4);
    }
}
