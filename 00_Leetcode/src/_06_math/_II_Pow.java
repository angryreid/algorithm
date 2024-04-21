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
        // -5 >> 1 = -3
        // 5 >> 1 = 2
        return half;
    }

    public double myPow3(double x, int n) {
        if (n == 0)
            return 1;
        if (n < 0) {
            x = 1 / x;
            n = -n; // this line will have stack overflow
        }
        boolean odd = (n & 1) == 1;
        double half = myPow3(x, n >> 1);
        half *= half;
        if (odd) {
            half *= x;
        }
        return half;
    }

    public double myPow4(double x, int n) {
        double res = 1.0;
        boolean neg = n < 0;
        long y = neg ? -((long) n) : n;
        while (y > 0) {
            if ((y & 1) == 1) {
                res *= x;
            }
            x *= x;
            y >>= 1;
        }
        return neg ? (1 / res) : res;
    }

    // Method to calculate (x^y) mod p
    public int myPowMod(int x, int y, int p) {
        // If x, y, or p is less than or equal to 0, return 0
        if (x < 0 || y < 0 || p <=0) return 0;
        // Initialize the result to 1
        int pow = 1;
        // While y is greater than 0
        while (y > 0) {
            // If y is odd
            if ((y & 1) == 1) {
                // Multiply pow by x and reduce the result modulo p
                pow = (pow * x) % p;
            }
            // Square x and reduce the result modulo p
            x = (x * x) % p;
            // Divide y by 2
            y >>= 1;
        }
        // Return the result
        return pow;
    }
}
