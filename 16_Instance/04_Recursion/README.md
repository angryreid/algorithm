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