package emma;

public class Main {
  // main method
  public static void main(String[] args) {
    // test skip list function
    // testSkipList();
    // to compare skip list with tree map
    testTime();

  }

  // test time for skip list and tree map
  static void testTime() {
    // test skip list
    SkipList<Integer, Integer> list = new SkipList<>();
    long start = System.nanoTime();
    for (int i = 0; i < 200000; i++) {
      list.put(i, i);
    }
    for (int i = 0; i < 200000; i++) {
      list.get(i);
    }
    for (int i = 0; i < 200000; i++) {
      list.remove(i);
    }
    long end = System.nanoTime();
    System.out.println("SkipList: " + (end - start) / 1000000000.0 + " s");

    // test tree map
    java.util.TreeMap<Integer, Integer> map = new java.util.TreeMap<>();
    start = System.nanoTime();
    for (int i = 0; i < 200000; i++) {
      map.put(i, i);
    }
    for (int i = 0; i < 200000; i++) {
      map.get(i);
    }
    for (int i = 0; i < 200000; i++) {
      map.remove(i);
    }
    end = System.nanoTime();
    System.out.println("TreeMap: " + (end - start) / 1000000000.0 + " s");
  }

  // test skip list function
  static void testSkipList() {
    SkipList<Integer, Integer> list = new SkipList<>();
    list.put(1, 1);
    list.put(2, 2);
    list.put(3, 3);
    list.put(4, 4);
    list.put(5, 5);
    list.put(6, 6);
    list.put(4, 66);
    System.out.println(list);
    System.out.println(list.get(4));
    System.out.println(list.remove(4)); 
    System.out.println(list);

    // test skip list function
    SkipList<String, String> list2 = new SkipList<>();
    list2.put("jack", "jack");
    list2.put("rose", "rose");
    list2.put("jim", "jim");
    list2.put("jake", "jake");
    list2.put("jake", "jake2");
    System.out.println(list2);
    System.out.println(list2.get("jake"));
    System.out.println(list2.remove("jake"));
    System.out.println(list2);
    
  }

}
