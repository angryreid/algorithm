package emma;

import java.util.Comparator;

public class Main {
  //  Method-1：自定义一个类用于实现比较器
  private static class PersonComparator implements Comparator<Person> {

    @Override
    public int compare(Person el1, Person el2) {
      // TODO Auto-generated method stub
      return el1.getAge() - el2.getAge();
    }

  }

  public static void main(String[] args) {
    BinarySearchTree<Person> bstBinarySearchTree = new BinarySearchTree<Person>(new PersonComparator());
    // anonymous class：定义一个匿名内部类比较器
    BinarySearchTree<Person> bstBinarySearchTree2 = new BinarySearchTree<Person>(new Comparator<Person>() {

      @Override
      public int compare(Person o1, Person o2) {
        // TODO Auto-generated method stub
        return o1.getAge() - o2.getAge();
      }
    });
  }
}
