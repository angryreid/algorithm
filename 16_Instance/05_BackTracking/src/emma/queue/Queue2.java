package emma.queue;

public class Queue2 {
    /**
     * col has queue or not
     */
    boolean[] cols;
    // 2 * (2*n - 1) bias count
    boolean[] negativeBias; // left top -> right bottom (row - col + n - 1)
    boolean[] positiveBias; // left bottom -> right top (row + col)
    int ways;

    public void placeQueue(int n) {
        if (n < 1) return;
        cols = new boolean[n];
        positiveBias = new boolean[(n << 1) - 1];
        negativeBias = new boolean[(n << 1) - 1];
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
//            show();
            return;
        }
        for (int col = 0; col < cols.length; col++) {
            if (cols[col]) continue;
            int negativeBiasIdx = row - col + cols.length - 1;
            if(negativeBias[negativeBiasIdx]) continue;
            int positiveBiasIdx = row + col;
            if(positiveBias[positiveBiasIdx]) continue;

            cols[col] = true;
            negativeBias[negativeBiasIdx] = true;
            positiveBias[positiveBiasIdx] = true;

            place(row + 1);
            // Back tracking starting at here
            cols[col] = false;
            negativeBias[negativeBiasIdx] = false;
            positiveBias[positiveBiasIdx] = false;
        }
    }

    public void show() {
//        for (int row = 0; row < cols.length; row++) {
//            for (int col = 0; col < cols.length; col++) {
//                if(cols[row] == col) {
//                    System.out.print("1 ");
//                } else {
//                    System.out.print("0 ");
//                }
//            }
//            System.out.println();
//        }
        System.out.println("====================");
    }
}
