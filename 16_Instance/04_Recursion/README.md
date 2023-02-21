# Recursion

Split the main question into multiple sub-question. return value from sub-question to main question.

**Eg:**

```java
public class Fib {
    public int fib0(int n) { // Time Complexity: O(2^n)
        if (n <= 2) return 1;
        return fib0(n - 1) + fib0(n - 2); // fib0(n - 1) must execute completed then beginning the process of fib0(n - 2)
    }

    public int fib1(int n) { // Time Complexity: O(n)
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
}
```

## Recursion -> Un-recursion

Sample code

```java

public static void log(int n) {
    if (n < 1) return;
    log(n - 1);
    int v = n + 10;
    System.out.println(v);
}
```

1. To define a stack to save variable. The space complexity has no changes.

```java
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
```

2. At sometimes, it can be use replicated variable to reduce the space complexity.

```java
public static void logLite(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println(i + 10);
        }
    }
```

3. Tail Recursion