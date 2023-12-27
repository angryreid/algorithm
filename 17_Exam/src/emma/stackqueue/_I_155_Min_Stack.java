package emma.stackqueue; // Define the package

import java.util.Stack;

public class _I_155_Min_Stack { // Define the class
  private Stack<Integer> stack;
  private Stack<Integer> minStack;

  public _I_155_Min_Stack() { // Define the constructor
    stack = new Stack<>();
    minStack = new Stack<>();
    minStack.push(Integer.MAX_VALUE); // Push the maximum value onto the minStack
  }

  public void push(int val) { // Define a method to push a value onto the stack
    stack.push(val);
    minStack.push(Math.min(val, minStack.peek()));
  }

  public void pop() { // Define a method to remove the top element from the stack
    if (!stack.isEmpty()) {
      stack.pop();
      minStack.pop();
    }
  }

  public int top() { // Define a method to get the top element of the stack
    if (!stack.isEmpty()) {
      return stack.peek();
    }
    return -1; // Return -1 or any other value indicating an error
  }

  public int getMin() { // Define a method to get the minimum element in the stack
    if (!minStack.isEmpty()) {
      return minStack.peek();
    }
    return -1; // Return -1 or any other value indicating an error
  }
}