package emma.hanoi;

public class Hanoi {
    /**
     *
     * @param n number
     * @param start
     * @param mid
     * @param end
     */
    public void hanoi(int n, String start, String mid, String end) {
        if (n == 1) {
            move(n, start, end);
            return;
        }
        hanoi(n - 1, start, end, mid);
        move(n, start, end);
        hanoi(n - 1, mid, start, end);
    }

    public void move(int no, String from, String to) {
        System.out.println("Moved number# " + no + " " + from + " -> " + to);
    }
}
