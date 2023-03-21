package emma;

public class Main {


    public static int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int first = nums[0];
        while (l <= r) {
            int mid = l + (r - l) / 2;
            System.out.println(mid);
            if (first > nums[mid]) r = mid - 1;
            else l = mid + 1;
        }
        if (target >= first) {
            l = 0;
        } else {
            r = nums.length - 1;
        }
        while(l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3};
        int[] arr2 = { 4,5,6,7,0,1,2 };
        System.out.println(search(arr, 3));
        System.out.println(search(arr2, 7));
    }
}
