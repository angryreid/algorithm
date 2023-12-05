package emma;
// import brute force

public class Main {

    // to create assertEquals method
    public static void assertEquals(int expected, int actual) {
        if (expected == actual) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed, expected: " + expected + ", actual: " + actual);
        }
    }

    public static void testBruteForce1() {
        // test brute force
        String text = "Hello, world!";
        String pattern = "world";
        int index = BruteForce01.indexOf(text, pattern);
        // print pattern index with more information
        System.out.println(index);
        pattern = "or";
        index = BruteForce01.indexOf(text, pattern);
        System.out.println(index);
        pattern = "abc";
        index = BruteForce01.indexOf(text, pattern);
        System.out.println(index);
    }

    public static void testBruteForce2() {
        // test brute force2
        String text = "Hello, world!";
        String pattern = "world";
        int index = BruteForce02.indexOf(text, pattern);
        // print pattern index with more information
        System.out.println(index);
        pattern = "or";
        index = BruteForce02.indexOf(text, pattern);
        System.out.println(index);
        pattern = "abc";
        index = BruteForce02.indexOf(text, pattern);
        System.out.println(index);

        // plz use assertEquals to test your code
        // write your code here
        // Test case 1: pattern is found at the beginning of the text
        String text1 = "hello world";
        String pattern1 = "hello";
        int expected1 = 0;
        int actual1 = BruteForce02.indexOf(text1, pattern1);
        assertEquals(expected1, actual1);

    }

    public static void main(String[] args) {
        // testBruteForce2();
        testKMP();

    }

}
