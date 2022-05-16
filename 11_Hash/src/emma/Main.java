package emma;

public class Main {
   

    public static void testFloatToInt() {
        int code = hashFloatCode(10.8f);
        System.out.println(code);
        System.out.println(Integer.toBinaryString(code));
    }

    public static int hashFloatCode(float num) {
        return Float.floatToIntBits(num);
    }

    public static int hashLongCode(long num) { // long is integer type
        return (int)(num ^ (num >>> 32));
    }

    public static int hashDoubleCode(double num) { // double is float type, need to convert as integer
        long bits = Double.doubleToLongBits(num);
        return (int)(bits ^ (bits >>> 32));
    }

    public static int hashStringCode(String str) {
        // j*n^3 + a*n^2 + c*n^1 + k*n^0 === ((j*n + a)*n + c)*n + k

        return 0;
    }

    public static void testMagicNumber() {
        int[] nums = new int[]{10, 11, 21, 34};
        for (int i: nums) {
            System.out.println((31 * i) + " " + ((i << 5) - i));
        }
    }

    public static void main(String[] args) {
        testMagicNumber();
    }
}
