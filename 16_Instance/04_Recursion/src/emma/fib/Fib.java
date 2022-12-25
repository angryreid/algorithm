package emma.fib;

public class Fib {
    public int fib0(int n) {
        if (n <= 2) return 1;
        return fib0(n - 1) + fib0(n - 2);
    }

    public int fib1(int n) {
        if (n <= 2) return 1;
        int[] memory = new int[n + 1];
        memory[1] = memory[2] = 1;
        return fib1(n - 1, memory) + fib1(n - 2, memory);
    }

    public int fib1(int n, int[] memory) {
        if (memory[n] == 0) {
            memory[n] = fib1(n - 1, memory) + fib1(n - 2, memory);
        }
        return memory[n];
    }

    public int fib2(int n) {
        if (n <= 2) return 1;
        int[] memory = new int[n + 1];
        memory[1] = memory[2] = 1;
        for (int i = 3; i <= n; i++) {
            memory[i] = memory[i - 1] + memory[i - 2];
        }
        return memory[n];
    }

    public int fib3(int n) {
        if (n <= 2) return 1;
        int[] memory = new int[2];
        memory[0] = memory[1] = 1;
        for (int i = 3; i <= n; i++) {
            memory[i % 2] = memory[(n - 1) % 2] + memory[(n - 2) % 2];
        }
        return memory[n%2];
    }
    public int fib4(int n) {
        if (n <= 2) return 1;
        int pre, next;
        pre = next = 1;
        for (int i = 3; i <= n; i++) {
//            int backup = next;
//            next = next + pre;
//            pre = backup;
            next = next + pre;
            pre = next - pre;
        }
        return next;
    }

    public int climbStairs(int n) {
        if (n <= 2) return n;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public int climbStairs2(int n) {
        if (n <= 2) return n;
        int pre = 1, next = 2;
        for (int i = 3; i <= n; i++) {
            next = next + pre;
            pre = next - pre;
        }
        return next;
    }
}
