package _01_two_pointer;

public class _1574_2 {
    // https://leetcode.cn/problems/shortest-subarray-to-be-removed-to-make-array-sorted/
    public static void main(String[] args) {
        int[] arr = {1,2,3,10,4,2,3,5};
        System.out.println(findLengthOfShortestSubarray(arr));
    }

    public static int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int j = n - 1;
        while(j > 0 && arr[j-1] <= arr[j]){
            j--;
        }
        if(j == 0){
            return 0;
        }
        int res = j;
        for(int i = 0; i < n; i++){
            while(j < n && arr[j] < arr[i]){
                j++;
            }
            res = Math.min(res, j - i - 1);
            if(i != n - 1 && arr[i + 1] < arr[i]){
                break;
            }
        }
        return res;
    }
}
