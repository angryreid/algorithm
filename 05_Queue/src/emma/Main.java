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

  /**
   * leetcode . 999
   * 
   * @param board
   * @return
   */
  public static int numRookCaptures(char[][] board) {
    // 1.Firstly, you should know the shape of the board in cartesian coordinate
    // system.
    // It might looks like this;
    // 0------>y
    // |
    // |
    // v
    // x

    // 2. Define 4 directions;
    // top, right, bottom,left;
    int[] dx = { -1, 0, 1, 0 };
    int[] dy = { 0, 1, 0, -1 };

    for (int i = 0; i < 8; i++) { // x
      for (int j = 0; j < 8; j++) { // y
        if (board[i][j] == 'R') { // Get R
          int res = 0;
          // Check 4 direction if there is a 'p' or 'B'
          for (int k = 0; k < 4; k++) {
            int x = i, y = j;
            while (true) {
              x += dx[k];
              y += dy[k];
              if (x < 0 || x >= 8 || y < 0 || y >= 8 || board[x][y] == 'B') {
                break;
              }
              if (board[x][y] == 'p') {
                res++;
                break;
              }
            }
          }
          return res;
        }
      }
    }
    return 0;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
//    test();
//    testMyQueue();
//    int[] nums = { 1, 2, 2, 3, 8 };
//    System.out.println(massage(nums));
    char[][] charArr = { { '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', 'p', '.', '.', '.', '.' },
        { '.', '.', '.', 'R', '.', '.', '.', 'p' }, { '.', '.', '.', '.', '.', '.', '.', '.' },
        { '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', 'p', '.', '.', '.', '.' },
        { '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.' } };
//    testDeque();
    System.out.println(numRookCaptures(charArr)); // 3
    System.out.println(Math.ceil(5 / 2));
    System.out.println(Math.floor(5 / 2));
  }

}
