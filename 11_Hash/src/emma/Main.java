package emma;

import emma.model.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
   

    public static void testFloatToInt() {
        int code = hashFloatCode(10.8f);
        System.out.println(code);
        System.out.println(Integer.toBinaryString(code));
    }

    public static int hashFloatCode(float num) {
        return Float.floatToIntBits(num);
    }

    public static int hashLongCode(long num) { // long is integer type
        return (int)(num ^ (num >>> 32));
    }

    public static int hashDoubleCode(double num) { // double is float type, need to convert as integer
        long bits = Double.doubleToLongBits(num);
        return (int)(bits ^ (bits >>> 32));
    }

    public static int hashStringCode(String str) {
        // j*n^3 + a*n^2 + c*n^1 + k*n^0 === ((j*n + a)*n + c)*n + k
        int len = str.length();
        int hash = 0;
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            System.out.println(c * 1);
//            hash = hash * 31 + c;
            hash = (hash << 5) - 1 + c;
        }
        return hash;
    }

    public static void testMagicNumber() {
        int[] nums = new int[]{10, 11, 21, 34};
        for (int i: nums) {
            System.out.println((31 * i) + " " + ((i << 5) - i));
        }
    }

    public static void testPrimerHash() {
        Integer num = 1209;
        Float fum = 12.09f;
        Long lum = 1209l;
        Double dum = 12.9d;
        String str = "emma";

        System.out.println(num.hashCode());
        System.out.println(fum.hashCode());
        System.out.println(lum.hashCode());
        System.out.println(dum.hashCode());
        System.out.println(str.hashCode());

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(1);
        list2.add(1);
        int listHash = list.hashCode();
        int listTwoHash = list2.hashCode();
        System.out.println("List hash: " + listHash);
        System.out.println("List hash: " + listTwoHash);
    }

    public static void testPerson() {
        Person nick = new Person("nick", 20, 1.75f);
        Person emma = new Person("nick", 20, 1.75f);
//        Person emma = new Person("emma", 19, 1.55f);
//        System.out.println("Nick hashCode is: " + nick.hashCode());
//        System.out.println("Emma hashCode is: " + emma.hashCode());
        // Nick hashCode is: 1554874502
        // Emma hashCode is: 1846274136

        // With override hashCode
        System.out.println("Nick hashCode is: " + nick.hashCode());
        System.out.println("Emma hashCode is: " + emma.hashCode());
        // Nick hashCode is: -1135353225
        // Emma hashCode is: -1135353225
        Map<Person, String> map = new HashMap<>();
        map.put(nick, "nick");
        map.put(emma, "emma");

        System.out.println("Map size: " + map.size());
        System.out.println("Map fetch Emma hashCode is: " + map.get(emma));
        System.out.println("Map fetch Nick hashCode is: " + map.get(nick));

    }


    public static void main(String[] args) {
//        testMagicNumber();
//        System.out.println(hashStringCode("jack"));
//        testPrimerHash();
        testPerson();
    }
}
