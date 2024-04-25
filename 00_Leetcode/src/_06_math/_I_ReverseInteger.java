package _06_math;

public class _I_ReverseInteger {
    /**
     * Int type size [-2^31, 2^31 - 1]
     * @param x
     * @return
     */
    public int reverse(int x) {
        boolean negtive = x < 0;
        x = negtive ? -x : x;
        int res = 0;
        while (x != 0) {
            int tail = x % 10;
            res = res * 10 + tail;
            x = x / 10;
        }
        return negtive ? -res : res;
    }
}
