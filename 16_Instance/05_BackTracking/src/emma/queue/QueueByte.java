package emma.queue;

public class QueueByte {
    /**
     * col has queue or not
     */
    int[] queues;
    byte cols;
    short negativeBias;
    short positiveBias;
    int ways;

    public void placeQueue(int n) {
        if (n < 1) return;
        queues = new int[n];
        place(0);
        System.out.println(n + " -> " + ways);
    }

    /**
     * place queue at row.
     * @param row
     */
    public void place(int row) {
        if (row == queues.length) {
            ways++;
            return;
        }
        for (int col = 0; col < queues.length; col++) {
            int cv = 1 << col;
            if ((cols & cv) != 0) continue;
            int nv = 1 << (row - col + queues.length - 1);
            if((negativeBias & nv) != 0) continue;
            int pv = 1 << (row + col);
            if((positiveBias & pv) != 0) continue;

            queues[row] = col;
            cols |= cv;
            negativeBias |= nv;
            positiveBias |= pv;

            place(row + 1);
            // Back tracking starting at here
            cols &= ~cv;
            negativeBias &= ~nv;
            positiveBias &= ~pv;
        }
    }
}
