package emma.tool;

public class BinarySearch {
    public static int indexOf(int[] list, int v) {
        if (list == null || list.length == 0) return -1;
        // [start, end)
        int start = 0,end = list.length;
        while (start < end) {
            int mid = (start + end) >> 1;
            if (v < list[mid]) {
                end = mid;
            } else if (v > list[mid]) {
                start = mid + 1;
            } else  {
             return mid;
            }
        }
        return -1;
    }


    public static int search(int[] list, int v) {
        if (list == null || list.length == 0) return -1;
        // [start, end)
        int start = 0,end = list.length;
        while (start < end) {
            int mid = (start + end) >> 1;
            if (v < list[mid]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }
}
