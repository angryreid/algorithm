package emma;
// import brute force

public class Main {

    public static void main(String[] args) {
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
}
