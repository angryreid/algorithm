# Sort

In-place algorithm
Dependency only from existing source, using output to cover input source.

## Bubble Sort

The average time big O -> O(n^2)
The Space big O -> O(1)
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

## Selection sort

The average time big O -> O(n^2)
The Space big O -> O(1)
Stability -> Stable (The key point is when the numbers exchange their positions)

```java
public class Selection {
    public static void selectAsc(Integer[] list) {
        for (int tail = list.length - 1; tail > 0; tail--) {
            int maxIndex = 0;
            for (int head = 1; head <= tail; head++) {
                if (list[maxIndex] < list[head]) {
                    maxIndex = head;
                }
            }
            int temp = list[maxIndex];
            list[maxIndex] = list[tail];
            list[tail] = temp;
        }
    }
}
```

- The swaping time will extremely less than Bubble sort. So the performance will be enhanced.

### Enhancement

To use `HEAP` to select the `max` number, then the Time Big O -> O(nlogn)

## Heap Sort

The average time big O -> O(nlogn)
The Space big O -> O(1)
Stability -> not Stable

```java
public class HeapSort extends Sort {
    private int size;

    public void sort() {
        size = list.length;
        // In-place creating HEAP via siftDown
        for (int i = ((size >> 1) - 1); i >= 0; i--) {
            siftDown(i);
        }

        while (size > 1) {
            // Heap excludes the max number by reduce the size
            swap(0, --size);
            // One time siftDown will move the max number to the top
            siftDown(0);
        }
    }

    private void siftDown(int index) {
        Integer element = list[index];
        int half = size >> 1;
        while (index < half) {
            int childIndex = (index << 1) + 1;
            Integer child = list[childIndex];
            int rightIndex = childIndex + 1;
            if (rightIndex < size && cmpEl(list[rightIndex], child) > 0) {
                child = list[childIndex = rightIndex];
            }
            if (cmpEl(element, child) >= 0) break;
            list[index] = child;
            index = childIndex;
        }
        list[index] = element;
    }
}
```

### Comparasion

To compare 10000 numbers

`
[HeapSort]
Cost：0.004s(4ms) 	Compared count：235.29k	 Swap count：10.00k
------------------------------------------------------------------
[SelectionSort]
Cost：0.091s(91ms) 	Compared count：49.99m	 Swap count：10.00k
------------------------------------------------------------------
[BubbleSort]
Cost：0.547s(547ms) 	Compared count：49.99m	 Swap count：24.89m
------------------------------------------------------------------
`


