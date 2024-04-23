package _06_math;

import java.util.ArrayList;
import java.util.List;

public class _II_SpiralMatrix {
    // error: cannot find symbol: class List
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null) return null;
        List<Integer> res = new ArrayList<>();
        int len = matrix.length;
        if (len == 0) return res;

        int top = 0, bottom = len - 1;
        int left = 0, right = matrix[0].length - 1;
        while (top <= bottom && left <= right) {
            // left top -> right top
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom ; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            
            for (int i = right; i >= left ; i--) {
                res.add(matrix[bottom][i]);
            }
            bottom--;

            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            left++;
        }
        return res;
    }


    public List<Integer> spiralOrder2(int[][] matrix) {
         if (matrix == null) return null;
         List<Integer> res = new ArrayList<>();
         int len = matrix.length;
         if (len == 0) return res;

         int top = 0, bottom = len - 1;
         int left = 0, right = matrix[0].length - 1;
         while (top <= bottom && left <= right) {
             // left top -> right top
             for (int i = left; i <= right; i++) {
                 res.add(matrix[top][i]);
             }
             top++;
             // right top -> right bottom
             for (int i = top; i <= bottom ; i++) {
                 res.add(matrix[i][right]);
             }
             right--;
             // right bottom -> left bottom
             if (top <= bottom) {
                 for (int i = right; i >= left ; i--) {
                     res.add(matrix[bottom][i]);
                 }
             }
             bottom--;
             // left bottom -> left top
             if (left <= right) {
                 for (int i = bottom; i >= top; i--) {
                     res.add(matrix[i][left]);
                 }
             }
             left++;
         }
         return res;
    }

    public List<Integer> spiralOrder3(int[][] matrix) {
        if (matrix == null) return null;
        List<Integer> res = new ArrayList<>();
        int len = matrix.length;
        if (len == 0) return res;

        int top = 0, bottom = len - 1;
        int left = 0, right = matrix[0].length - 1;
        while (top <= bottom && left <= right) {
            // left top -> right top
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom ; i++) {
                res.add(matrix[i][right]);
            }
            right--;

            if (top > bottom || left > right) break;

            for (int i = right; i >= left ; i--) {
                res.add(matrix[bottom][i]);
            }
            bottom--;

            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            left++;
        }
        return res;
    }
}
