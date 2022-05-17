package emma.model;

public class Person {
    private String name;
    private int age;
    private float height;

    public Person(String name, int age, float height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    @Override
    public int hashCode() {
        int hashCode = Integer.hashCode(age);
        hashCode = hashCode * 31 + Float.hashCode(height);
        hashCode = hashCode * 31 + (name != null ? name.hashCode() : 0);
        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != getClass()) return false; // Suggest
//        if (obj == null || !(obj instanceof Person)) return false;
        Person pObj = (Person)obj;
        return pObj.age == age && pObj.height == height && valueEquasl(name, pObj.name);
    }

    private boolean valueEquasl(Object v1, Object v2) {
        return v1 == null ? v2 == null : v1.equals(v2);
    }
}
