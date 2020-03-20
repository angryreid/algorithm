package emma;

public class Asserts {
  private static void test(boolean val) {
    // TODO Auto-generated method stub
    try {
      if (!val) {
        throw new Exception("Test is not passed!");
      }
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
    }

  }
}
