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
}
