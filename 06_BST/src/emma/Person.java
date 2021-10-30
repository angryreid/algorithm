package emma;

public class Person implements Comparable<Person> {// java.lang.Comparable
  private int age;

  public Person(int age) {
    this.age = age;
  }

  @Override
  public int compareTo(Person el) {
    // TODO Auto-generated method stub
    return age - el.age;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "Person{" +
            "age=" + age +
            '}';
  }
}
