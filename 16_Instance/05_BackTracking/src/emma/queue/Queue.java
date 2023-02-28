package emma.queue;

public class Queue {
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
            show();
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
            System.out.println("["+row+"]" + "["+col+"]" + "=false");
        }
        System.out.println("["+row+"]" + "["+col+"]" + "=true");
        return true;
    }

    public void show() {
        for (int row = 0; row < cols.length; row++) {
            for (int col = 0; col < cols.length; col++) {
                if(cols[row] == col) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
        System.out.println("====================");
    }
}
