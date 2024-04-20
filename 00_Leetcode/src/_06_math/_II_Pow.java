package _06_math;

public class _II_Pow {
    /**
     * basic solution to calculate x^n
     * @param x  base
     * @param n  power
     * @return x^n
     * 
     * Time complexity: O(n)
     */
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        double res = 1;
        if (n > 0) {
            while (n > 0) {
                res *= x;
                n--;
            }
        } else {
            n = -n;
            while (n > 0) {
                res = res / x;
                n--;
            }
        }

        return res;
    }

    public double myPow2(double x, int n) {
        if (n == 0)
            return 1;
        boolean odd = (n & 1) == 1;
        double half = myPow(x, n >> 1);
        half *= half;
        if (odd) {
            half *= x;
        }
        if (n < 0) {
            half = half / x;
        }
        return half;
    }
}
