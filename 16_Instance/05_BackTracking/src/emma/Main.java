package emma;

public class Main {
    public static void main(String[] args) {
        // write your code here
        new Main().placeQueue(8); // 92
    }

    /**
     * Array index is row and value is column
     */
    int[] cols;
    int ways;

    public void placeQueue(int n) {
        if (n < 1) return;
        cols = new int[n];
        place(0);
        System.out.println(n + " -> " + ways);
    }

    /**
     * place queue at row.
     * @param row
     */
    public void place(int row) {
        if (row == cols.length) {
            ways++;
            return;
        }
        for (int col = 0; col < cols.length; col++) {
            if(isValid(row, col)) {
                cols[row] = col;
                place(row + 1);
            }
        }
    }

    /**
     * if row & col can place queue
     * @param row
     * @param col
     * @return
     */
    public boolean isValid(int row, int col) {
        for (int r = 0; r < row; r++) {
            if (cols[r] == col) { // column placed.
                return false;
            }

            if (row - r == Math.abs(col - cols[r])) { // y2 - y1 / x2 - x1 = -1 / 1
                return false;
            }
        }
        return true;
    }
}
