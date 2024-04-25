package _06_math;

public class _I_ReverseInteger {
    /**
     * Int type size [-2^31, 2^31 - 1]
     * @param x
     * @return
     */
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            res = res * 10 +  x % 10;
            x = x / 10;
        }
        return res;
    }

    public int reverse2(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 +  x % 10;
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
            x = x / 10;
        }
        return (int) res;
    }
}
