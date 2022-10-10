# Sort

In-place algorithm
Dependency only from existing source, using output to cover input source.

## Bubble Sort

Author:
Date:

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

Author:
Date:

The average time big O -> O(n^2)
The Space big O -> O(1)
Stability -> Not Stable (The key point is when the numbers exchange their positions)

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

-   The swaping time will extremely less than Bubble sort. So the performance will be enhanced.

### Enhancement

To use `HEAP` to select the `max` number, then the Time Big O -> O(nlogn)

## Heap Sort

The average time big O -> O(nlogn)
The Space big O -> O(1)
Stability -> Not Stable

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
Cost：0.004s(4ms) Compared count：235.29k Swap count：10.00k

---

[SelectionSort]
Cost：0.091s(91ms) Compared count：49.99m Swap count：10.00k

---

[BubbleSort]
Cost：0.547s(547ms) Compared count：49.99m Swap count：24.89m

---

`

## Insertion Sort

Author:
Date:

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

## Merge Sort

Author: John von Neumanen
Date: 1945

The average time big O -> O(nlogn)
the best time big O -> O(nlogn)
The Space big O -> O(n)
Stability -> Stable

```java
public class MergeSort<E extends Comparable<E>> extends Sort<E> {
    private E[] leftArray;
    @Override
    protected void sort() {
        leftArray = (E[]) new Comparable[list.length >> 1];
        sort(0, list.length);
    }

    /**
     * sort at [start, end)
     * @param start
     * @param end
     */
    private void sort(int start, int end) {
        if ((end - start) < 2) return; // only one element
        int mid = (start + end) >> 1;
        sort(start, mid);
        sort(mid, end);
        merge(start, mid, end);
    }

    /***
     * Merge [start, mid), [mid, end)
     * @param start
     * @param mid
     * @param end
     */
    private void merge(int start, int mid, int end) {
        int leftStart = 0, leftEnd = mid - start, rightStart = mid, rightEnd = end, index = start;
        // Copy left array.
        for (int i = leftStart; i < leftEnd; i++) {
            leftArray[i] = list[index + i];
        }

        while (leftStart < leftEnd) {
            if(rightStart < rightEnd && cmp(list[rightStart], leftArray[leftStart]) < 0) {
                list[index++] = list[rightStart++];
            } else {
                list[index++] = leftArray[leftStart++];
            }
        }
    }
}
```

## Quick Sort

Author: Tony Hoare
Date: 1960

The average time big O -> O(nlogn)
the best time big O -> O(nlogn)
the baddest time big O -> O(n^2)
The Space big O -> O(nlogn)
Stability -> Not Stable

```java
public class QuickSort<E extends Comparable<E>> extends Sort<E> {
    @Override
    protected void sort() {
        sort(0, list.length);
    }

    /**
     * [start, end)
     * @param start
     * @param end
     */
    private void sort(int start, int end) {
        if (end - start < 2) return;// At lest 2 elements required.
        // 1. Find the pivot
        int pivot = pivotIndex(start, end);
        // 2. Sort sub list
        sort(start, pivot);
        sort(pivot + 1, end);
    }

    /**
     * Find the pivot from [start, end)
     * @param start
     * @param end
     * @return Index of pivot
     */
    private int pivotIndex(int start, int end) {
        E pivotValue = list[start];
        end--;// Point at the last element position
        while (start < end) {
            while (start < end) {
                if (cmp(pivotValue, list[end]) < 0) {
                    end--;
                } else {
                    list[start++] = list[end];
                    break;
                }
            }
            while (start < end) {
                if (cmp(pivotValue, list[start]) > 0) {
                    start++;
                } else {
                    list[end--] = list[start];
                    break;
                }
            }
        }
        list[end] = pivotValue;
        return end;
    }
}

```

## Shell Sort

Diminishing increment Sort

Author: Donald Shell
Date: 1959

The average time big O -> Depends on Step Sequence
the best time big O -> O(n)
the baddest time big O -> O(n^(4/3)) ~ O(n^2)
The Space big O -> O(1)
Stability -> Not Stable

**Step Sequence**

-   Shell Sequence: The baddest time complexity -> O(n^2)
-   Robert Sedgewick: The baddest time complexity -> O(n^(4/3))

```java
public class ShellSort<E extends Comparable<E>> extends Sort<E> {
    @Override
    protected void sort() {
//        List<Integer> stepSequence = shellStepSequence();
        List<Integer> stepSequence = sedgewickSequence();
        for (Integer step :
                stepSequence) {
            sort(step);
        }
    }

    /**
     * Split into steps column, Then sorting the element of each row.
     * @param step
     */
    private void sort(int step) {

        for (int col = 0; col < step; col++) {
            for (int start = col + step; start < list.length; start += step) {
                // index = col + row * step
                int cur = start;
                while (cur > col && cmp(cur, cur - step) < 0) {
                    swap(cur, cur - step);
                    cur -= step;
                }
            }
        }
    }

    private List<Integer> shellStepSequence() {
        List<Integer> stepSequence = new ArrayList<>();
        int step = list.length;
        while ((step >>= 1) > 0) {
            stepSequence.add(step);
        }
        return stepSequence;
    }

    private List<Integer> sedgewickSequence() {
        List<Integer> stepSequence = new ArrayList<>();
        int k = 0, step = 0, count = list.length;
        while(true) {
            if (k % 2 == 0) {
                int pow = (int) Math.pow(2, k >> 1);
                step = 1 + 9 * (pow * pow - pow);
            } else {
                int pow1 = (int) Math.pow(2, (k - 1) >> 1);
                int pow2 = (int) Math.pow(2, (k + 1) >> 1);
                step = 1 + 8 * pow1 * pow2 - 6 * pow2;
            }
            if (step >= count) break;
            stepSequence.add(0, step);
            k++;
        }
        return stepSequence;
    }
}
```

## Counting Sort

Author: Harold H. Seward
Date: 1954

Applying for sorting **integer** in area `[a, b]`

The average time big O -> O(n + k)
the best time big O -> O(n + k)
The Space big O -> O(n + k)
Stability -> Stable

### Code

#### Case 1

**Defects**

-   Wasting too much space
-   Can not to sort negative integer
-   Not stable

```java
public class CountingSort extends Sort<Integer>{
    @Override
    protected void sort() {
        // Find the biggest integer.
        int max = list[0];
        for (int i = 1; i < list.length; i++) {
            if (list[i] > max) {
                max = list[i];
            }
        }
        // Create a new Array with the biggest size.
        int[] counts = new int[max + 1];
        for (int i = 0; i < list.length; i++) {
            counts[list[i]]++;
        }
        // Sort origin list with counts.
        int index = 0;
        for (int i = 0; i < counts.length; i++) {
            int cnt = counts[i];
            while ((cnt--) > 0) {
                list[index++] = i;
            }
        }
    }
}

```

#### Case 2

The average time big O -> O(n + k)
the best time big O -> O(n + k)
The Space big O -> O(n + k)
Stability -> Stable

**Defects**

-   Wasting too much space: fixed
-   Can not to sort negative integer: fixed
-   Not stable: stable

```java
public class CountingSort extends Sort<Integer>{
    @Override
    protected void sort() {
        // Find the max, min integer.
        int max = list[0];
        int min = list[0];
        for (int i = 1; i < list.length; i++) {
            if (list[i] > max) {
                max = list[i];
            }
            if (list[i] < min) {
                min = list[i];
            }
        }
        // Create a new Array.
        int[] counts = new int[max - min + 1];
        for (int i = 0; i < list.length; i++) {
            counts[list[i] - min]++;
        }
        // Accumulation counts
        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }
        // Sort from tail to head to make sure the stability

        int[] sortedList = new int[list.length];
        for (int i = list.length - 1; i >= 0; i--) {
            sortedList[--counts[list[i] - min]] = list[i];
        }

        for (int i = 0; i < sortedList.length; i++) {
            list[i] = sortedList[i];
        }
    }
}


```

## Radix Sort

Author:
Date:

Applying for sorting **integer**, especial negative integer sorting.

The average time big O -> O(d(n + k)) d -> numbers length, `(n + k)` is counting sort
the best time big O -> O(d(n + k))
the baddest time big O -> O(d(n + k))
The Space big O -> O(n + k)
Stability -> Stable

**Mod**

`number / position % 10`

### Code

#### Case 1

```java
public class RadixSort extends Sort<Integer>{
    @Override
    protected void sort() {
        // Find the max, min integer.
        int max = list[0];
        for (int i = 1; i < list.length; i++) {
            if (list[i] > max) {
                max = list[i];
            }
        }

        for (int divider = 1; divider <= max; divider *= 10) {
            countingSort(divider);
        }
    }

    protected void countingSort(int divider) {

        // Create a new Array.
        int[] counts = new int[10];
        for (int i = 0; i < list.length; i++) {
            // Save radix counting
            counts[list[i] / divider % 10]++;
        }
        // Accumulation counts
        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }
        // Sort from tail to head to make sure the stability

        int[] sortedList = new int[list.length];
        for (int i = list.length - 1; i >= 0; i--) {
            // Place the actual element.
            sortedList[--counts[list[i] / divider % 10]] = list[i];
        }

        for (int i = 0; i < sortedList.length; i++) {
            list[i] = sortedList[i];
        }
    }
}
```

#### Case 2

TO DO: Create 10 Array to implement Radix Sort

## Bucket Sort

Author:
Date:

Bucket Sort can define the divide bucket element rule with diff situation.

The average time big O -> O(n + k) k is `n * logn - n * logm`
the best time big O -> O(n + k)
the baddest time big O -> O(n + k)
The Space big O -> O(n + m) m is the size of bucket
Stability -> Stable

### Code

#### Case 1

```java

```
