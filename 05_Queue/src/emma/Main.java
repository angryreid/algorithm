package emma;

public class Main {
  static void test() {
    Queue<Integer> queue = new Queue<Integer>();
    queue.enQueue(1);
    queue.enQueue(2);
    queue.enQueue(3);
    queue.enQueue(4);
    while (!queue.isEmpty()) {
      System.out.println(queue.deQueue());
    }
  }

  static void testMyQueue() {
    MyQueue queue = new MyQueue();
    queue.push(1);
    queue.push(2);
    System.out.println(queue.peek());
    System.out.println(queue.pop());
    System.out.println(queue.empty());
//    queue.peek();  // 返回 1
//    queue.pop();   // 返回 1
//    queue.empty(); // 返回 false
  }

  /**
   * 面试题 17.16. 按摩师
   * 
   * @param nums
   * @return
   */
  public static int massage(int[] nums) { // https://leetcode-cn.com/problems/the-masseuse-lcci/
    int first = 0;
    int second = 0;

    for (int i : nums) {
      int temp = second;
      second = Math.max(second, first + i);
      first = temp;
    }
    return second;
  }

  public static void testDeque() {
    Deque<Integer> deque = new Deque<Integer>();
    deque.enQueueRear(1);
    deque.enQueueRear(2);
    deque.enQueueRear(3);
    deque.enQueueRear(4);
    while (!deque.isEmpty()) {
//      System.out.println(deque.deQueueFront());
      System.out.println(deque.deQueueRear());
    }
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
//    test();
//    testMyQueue();
//    int[] nums = { 1, 2, 2, 3, 8 };
//    System.out.println(massage(nums));
    
    testDeque();
  }

}
