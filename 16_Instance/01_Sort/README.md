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

## Insertion Sort

The average time big O -> O(n^2)
the best time big O -> O(n)
The Space big O -> O(1)
Stability -> Stable

```java
public class InsertionSort<E extends Comparable<E>> extends Sort<E> {
    @Override
    protected void sort() {
        for (int head = 1; head < list.length; head++) {
            int tail = head;
            while (tail > 0 && cmp(tail, tail - 1) < 0) {
                swap(tail, tail - 1);
                tail--;
            }
        }
    }
}
```

### Enhancement

#### Case 1

To reduce exchange times.

```java
public class InsertionSort<E extends Comparable<E>> extends Sort<E> {
    @Override
    protected void sort() {
        for (int head = 1; head < list.length; head++) {
            int tail = head;
            E copyHead = list[tail];
            while (tail > 0 && cmp(copyHead, list[tail - 1]) < 0) {
                list[tail] = list[tail - 1];
                tail--;
            }
            list[tail] = copyHead;
        }
    }
}
```

#### Case 2

To use binary search.

```java
public class InsertionSort<E extends Comparable<E>> extends Sort<E> {
    @Override
    protected void sort() {
        for (int head = 1; head < list.length; head++) {
            insert(head, search(head));
        }
    }

    private void insert(int source, int dest) {
        E v = list[source];
        for (int i = source; i > dest ; i--) {
            list[i] = list[i - 1];
        }
        list[dest] = v;
    }


    /**
     * The cur position of sorting list
     * @param index
     * @return
     */
    private int search(int index) {
        E v = list[index];
        int start = 0,end = index;
        while (start < end) {
            int mid = (start + end) >> 1;
            if (cmp(v, list[mid]) < 0) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }
}
```
