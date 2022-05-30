# Sort

## Bubble Sort

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
            System.out.println("Round ==== " + (i + 1) + "====Start");
            for (int k = 0; k < list.length; k++) {
                System.out.print(" " + list[k] + " ");
                if (k == list.length - 1) {
                    System.out.println();
                }
            }
        }
        for (int i = 0; i < list.length; i++) {
            System.out.print(" " + list[i]);
        }
//        System.out.println("Sorting list: " + list.toString());
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

        // After sorted
        for (int i = 0; i < list.length; i++) {
            System.out.print(" " + list[i]);
        }
//        System.out.println("Sorting list: " + list.toString());
    }
}
```