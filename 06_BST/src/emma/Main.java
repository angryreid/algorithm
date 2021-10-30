package emma;

import java.util.Comparator;

import emma.BinarySearchTree.Accessor;
import file.Files;
import printer.BinaryTrees;

public class Main {
  // Method-1：自定义一个类用于实现比较器
  private static class PersonComparator implements Comparator<Person> {

    @Override
    public int compare(Person el1, Person el2) {
      // TODO Auto-generated method stub
      return el1.getAge() - el2.getAge();
    }

  }

  public static void testComparator() {
    BinarySearchTree<Person> bstBinarySearchTree = new BinarySearchTree<Person>(new PersonComparator());
    // anonymous class：定义一个匿名内部类比较器
    BinarySearchTree<Person> bstBinarySearchTree2 = new BinarySearchTree<Person>(new Comparator<Person>() {// Person

      @Override
      public int compare(Person o1, Person o2) {
        // TODO Auto-generated method stub
        return o1.getAge() - o2.getAge();
      }
    });
    BinarySearchTree<Integer> bstBinarySearchTree3 = new BinarySearchTree<Integer>();// Integer
    int[] treeArray = { 54, 24, 6, 68, 65, 44, 74, 60, 9 };
    for (int num : treeArray) {
      bstBinarySearchTree.add(new Person(num));
      bstBinarySearchTree3.add(num);
    }
    BinaryTrees.print(bstBinarySearchTree3);
    BinaryTrees.print(bstBinarySearchTree);
    String str = BinaryTrees.printString(bstBinarySearchTree3);
    Files.writeToFile("/Users/lydia/Documents/repo/algorithm/06_BST/src/text/bst.txt", str);
  }

  public static void testOrderTraveral() {
    BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();// Integer
    int[] treeArray = { 54, 24, 6, 68, 65, 44, 74, 60, 9 };
    for (int num : treeArray) {
      bst.add(num);
    }

    BinaryTrees.print(bst);
    System.out.println("\n");
    // bst.preorderTraversal(); // preorder traversal
    // bst.inorderTraversal(); // inorder traversal
    // bst.postorderTraversal(); // postorder traversal
    // bst.levelOrderTraversal(); // level-order traversal

    // using Accessor
    bst.levelOrderTraversal(new Accessor<Integer>() {

      @Override
      public void access(Integer el) {
        // TODO Auto-generated method stub
        System.out.print(el + "->");
      }

    });
    bst.showTravelOrder();
  }

  public static void main(String[] args) {
    testOrderTraveral();
    testComparator();
  }
}
