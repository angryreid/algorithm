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
        // Test case 1: pattern is found at the beginning of the text
        String text1 = "hello world";
        String pattern1 = "hello";
        int expected1 = 0;
        int actual1 = BruteForce02.indexOf(text1, pattern1);
        assertEquals(expected1, actual1);

        // Test case 2: pattern is found in the middle of the text
        String text2 = "quick brown fox jumps over the lazy dog";
        String pattern2 = "brown";
        int expected2 = 6;
        int actual2 = BruteForce02.indexOf(text2, pattern2);
        assertEquals(expected2, actual2);

        // Test case 3: pattern is found at the end of the text
        String text3 = "the quick brown fox";
        String pattern3 = "fox";
        int expected3 = 16;
        int actual3 = BruteForce02.indexOf(text3, pattern3);
        assertEquals(expected3, actual3);

        // Test case 4: pattern is not found in the text
        String text4 = "hello world";
        String pattern4 = "foo";
        int expected4 = -1;
        int actual4 = BruteForce02.indexOf(text4, pattern4);
        assertEquals(expected4, actual4);

        // Test case 5: text is null
        String text5 = null;
        String pattern5 = "hello";
        int expected5 = -1;
        int actual5 = BruteForce02.indexOf(text5, pattern5);
        assertEquals(expected5, actual5);

        // Test case 6: pattern is null
        String text6 = "hello world";
        String pattern6 = null;
        int expected6 = -1;
        int actual6 = BruteForce02.indexOf(text6, pattern6);
        assertEquals(expected6, actual6);

        // Test case 7: both text and pattern are null
        String text7 = null;
        String pattern7 = null;
        int expected7 = -1;
        int actual7 = BruteForce02.indexOf(text7, pattern7);
        assertEquals(expected7, actual7);

        // Test case 8: text is empty
        String text8 = "";
        String pattern8 = "hello";
        int expected8 = -1;
        int actual8 = BruteForce02.indexOf(text8, pattern8);
        assertEquals(expected8, actual8);

        // Test case 9: pattern is empty
        String text9 = "hello world";
        String pattern9 = "";
        int expected9 = -1;
        int actual9 = BruteForce02.indexOf(text9, pattern9);
        assertEquals(expected9, actual9);

        // Test case 10: text length is less than pattern length
        String text10 = "hello";
        String pattern10 = "world";
        int expected10 = -1;
        int actual10 = BruteForce02.indexOf(text10, pattern10);
        assertEquals(expected10, actual10);
    }

    
    public static void testKMP() {
        //  write test case with function assertEquals
        // Test case 1: pattern is found at the beginning of the text
        String text1 = "hello world";
        String pattern1 = "hello";
        int expected1 = 0;
        int actual1 = KMP.indexOf(text1, pattern1);
        assertEquals(expected1, actual1);

        // Test case 2: pattern is found in the middle of the text
        String text2 = "quick brown fox jumps over the lazy dog";
        String pattern2 = "brown";
        int expected2 = 6;
        int actual2 = KMP.indexOf(text2, pattern2);
        assertEquals(expected2, actual2);

        // Test case 3: pattern is found at the end of the text
        String text3 = "the quick brown fox";
        String pattern3 = "fox";
        int expected3 = 16;
        int actual3 = KMP.indexOf(text3, pattern3);
        assertEquals(expected3, actual3);

        // Test case 4: pattern is not found in the text
        String text4 = "hello world";
        String pattern4 = "foo";
        int expected4 = -1;
        int actual4 = KMP.indexOf(text4, pattern4);
        assertEquals(expected4, actual4);

        // Test case 5: text is null
        String text5 = null;
        String pattern5 = "hello";
        int expected5 = -1;
        int actual5 = KMP.indexOf(text5, pattern5);
        assertEquals(expected5, actual5);

        // Test case 6: pattern is null
        String text6 = "hello world";
        String pattern6 = null;
        int expected6 = -1;
        int actual6 = KMP.indexOf(text6, pattern6);
        assertEquals(expected6, actual6);

        // Test case 7: both text and pattern are null
        String text7 = null;
        String pattern7 = null;
        int expected7 = -1;
        int actual7 = KMP.indexOf(text7, pattern7);
        assertEquals(expected7, actual7);

        // Test case 8: text is empty
        String text8 = "";
        String pattern8 = "hello";
        int expected8 = -1;
        int actual8 = KMP.indexOf(text8, pattern8);
        assertEquals(expected8, actual8);

        // Test case 9: pattern is empty
        String text9 = "hello world";
        String pattern9 = "";
        int expected9 = -1;
        int actual9 = KMP.indexOf(text9, pattern9);
        assertEquals(expected9, actual9);

        // Test case 10: text length is less than pattern length
        String text10 = "hello";
        String pattern10 = "world";
        int expected10 = -1;
        int actual10 = KMP.indexOf(text10, pattern10);
        assertEquals(expected10, actual10);



    }

    public static void main(String[] args) {
        // testBruteForce2();
        testKMP();

    }
}
