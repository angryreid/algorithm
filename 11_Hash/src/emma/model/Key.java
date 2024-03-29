package emma.model;

public class Key {
    private int value;
    public Key(int value) {
        this.value = value;
    }

    public int  hashCode() {
        return value / 20;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != getClass()) return false;
        return ((Key)obj).value == value;
    }

    @Override
    public String toString() {
        return "(" + value + ")";
    }
}
