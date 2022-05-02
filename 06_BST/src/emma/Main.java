package emma;

import java.util.Comparator;

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
  }

  public static void testInorder() {
    BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();// Integer
    int[] treeArray = { 54, 24, 6, 68, 65, 44, 74, 60, 9 };
    for (int num : treeArray) {
      bst.add(num);
    }
    bst.inorder(new BinaryTree.Visitor<Integer>() {
      @Override
      boolean visit(Integer element) {
        System.out.print("_" + element + "_");
        return false;
      }
    });
  }

  public static void testPreorder() {
    BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();// Integer
    int[] treeArray = { 54, 24, 6, 68, 65, 44, 74, 60, 9 };
    for (int num : treeArray) {
      bst.add(num);
    }
    bst.preorder(new BinaryTree.Visitor<Integer>() {
      @Override
      boolean visit(Integer element) {
        System.out.print("_" + element + "_");
        return false;
      }
    });
  }

  public static void testPostorder() {
    BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();// Integer
    int[] treeArray = { 54, 24, 6, 68, 65, 44, 74, 60, 9 };
    for (int num : treeArray) {
      bst.add(num);
    }
    bst.postorder(new BinarySearchTree.Visitor<Integer>() {
      @Override
      boolean visit(Integer element) {
        System.out.print(element + "_");
        if (element == 24) {
          System.out.println();
          return true;
        } else {
          return false;
        }
      }
    });
  }

  public static void testHeight() {
    BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();// Integer
    int[] treeArray = { 54, 24, 6, 68, 65, 44, 74, 60, 9, 7, 8 };
    for (int num : treeArray) {
      bst.add(num);
    }

    System.out.println(bst.height());
    System.out.println(bst.heightLevel());

    bst.levelVisit(new BinarySearchTree.Visitor<Integer>() {
      @Override
      public boolean visit(Integer element) {
        System.out.print(element + "_");
        if (element == 6) {
          System.out.println();
          return true;
        } else {
          return false;
        }
      }
    });
    System.out.println();

    BinaryTrees.print(bst);
    System.out.println();
    System.out.println(bst.getPredesessor(6));
    System.out.println(bst.getPredesessor(24));
    System.out.println(bst.getSubdesessor(8));
    System.out.println(bst.getSubdesessor(54));
  }

  public static void remove() {
    BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();// Integer
    int[] treeArray = { 54, 24, 6, 68, 65, 44, 74, 60, 9, 7, 8 };
    for (int num : treeArray) {
      bst.add(num);
    }
    System.out.println("Before removing");
    BinaryTrees.print(bst);
    System.out.println("removed");
    System.out.println();
    bst.remove(24);
    BinaryTrees.print(bst);
  }

  public static void testOrder() {
    testPreorder();
    System.out.println();
    testInorder();
    System.out.println();
    testPostorder();
  }

  public static void main(String[] args) {
//    testOrderTraveral();
//    testComparator();
    testOrder();
//    testHeight();


//    remove();
  }
}
