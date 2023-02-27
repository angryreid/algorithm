package emma.tailCall;

public class TailCall {

    /**
     * Optimization by Compiler
     *
     * Tail function will keep executing in the source function
     *
     * Better to implement tail call which can help performance upgrade.
     */

    public static int factorial(int n) {
        if (n <= 1) return n;
        return n * factorial(n - 1);
    }

    public static int factorial(int n, int result) {
        if (n <= 1) return result;
        return factorial(n - 1, n * result);
    }

    public static int fib(int n) {
        return fib(n, 1, 1);
    }

    public static int fib(int n, int first, int second) {
        if (n <= 1) return first;
        return fib(n - 1, second, first + second);
    }

    public static void main(String[] args) {
        System.out.println(factorial(4));
        System.out.println(factorial(4, 1));
        System.out.println(fib(5));
    }
}
