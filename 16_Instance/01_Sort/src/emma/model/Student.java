package emma.model;

public class Student implements Comparable<Student>{
    private int score;
    private int age;
    public Student(int score, int age) {
        this.age = age;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Student o) {
        return age - o.age;
    }
}
