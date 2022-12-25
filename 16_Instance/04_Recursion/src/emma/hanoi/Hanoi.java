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
            System.out.println(start + " -> " + end);
            return;
        }
        hanoi(n - 1, start, end, mid);
        System.out.println(start + " -> " + end);
        hanoi(n - 1, mid, start, end);
    }
}
