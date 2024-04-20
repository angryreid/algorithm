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

    /**
     * optimized solution to calculate x^n
     * @param x  base
     * @param n  power
     * @return x^n
     * 
     * Time complexity: O(logn)
     */
    public double myPow2(double x, int n) {
        if (n == 0) return 1;
        if (n == -1) return 1 / x;
        boolean odd = (n & 1) == 1;
        double half = myPow2(x, n >> 1);
        half *= half;
        if (odd) {
            half *= x;
        }
        // if (n < 0) {
        //     half = half / x;
        // }
        return half;
    }

    public double myPow3(double x, int n) {
        if (n == 0)
            return 1;
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        boolean odd = (n & 1) == 1;
        double half = myPow3(x, n >> 1);
        half *= half;
        if (odd) {
            half *= x;
        }
        return half;
    }
}
