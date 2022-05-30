package emma.tool;

public class Asserts {
    public static void test(boolean value) {
        try {
            if (!value) throw new Exception("Test Case Failed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
