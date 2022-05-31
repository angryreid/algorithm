# Sort

## Bubble Sort

The average O -> O(n^2)
Stability -> Stable (The key point is when the numbers exchange their positions)

Case 1

```java
public class Main {
    public static void main(String[] args) {
        int[] list = {9, 3, 4, 5, 6, 8, 88, 45, 2, 2, 2};
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = i + 1; j < list.length; j++) {
                if (list[i] > list[j]) {
                    int temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
            }
        }
    }
}
```

Case 2

```java
public class Main {
    public static void main(String[] args) {
        int[] list = {9, 3, 4, 2, 5, 6, 8, 88, 45, 2, 2, 2};
        for (int i = 0; i < list.length; i++) {
            for (int j = 1; j < list.length - i; j++) {
                if (list[j] < list[j - 1]) {
                    int temp = list[j];
                    list[j] = list[j - 1];
                    list[j - 1] = temp;
                }
            }
        }
    }
}
```

Case 3: Enhanced

```java
public class Main {
    public static void main(String[] args) {
        int[] list = {9, 3, 4, 2, 5, 6, 8, 88, 45, 2, 2, 2};
        for (int i = list.length - 1; i > 0; i--) {
            boolean sort = true;
            for (int j = 1; j <= i; j++) {
                if (list[j] < list[j - 1]) {
                    int temp = list[j];
                    list[j] = list[j - 1];
                    list[j - 1] = temp;
                    sort = false;
                }
            }
            if (sort) break;
        }
    }
}
```