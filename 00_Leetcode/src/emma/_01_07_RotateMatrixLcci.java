package emma;

public class _01_07_RotateMatrixLcci {

  public static void rotate(int[][] matrix) {
    int n = matrix.length;
    // 先以对角线（左上-右下）为轴进行翻转
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {// i + 1; core
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }
    // 以每一行中心为轴进行翻转
    int mid = n / 2;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < mid; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[i][n - j - 1];
        matrix[i][n - j - 1] = temp;
      }
    }
  }

  public static void main(String[] args) {
    int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    rotate(matrix);
    System.out.println(matrix.toString());
  }
}
