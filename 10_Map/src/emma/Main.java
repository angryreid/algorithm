package emma;

import emma.file.Files;

import emma.file.FileInfo;

import java.util.ArrayList;
import java.util.List;

import emma.map.Map;
import emma.map.TreeMap;
import emma.set.Set;
import emma.set.TresSet;
import emma.time.Times;

public class Main {
    public static void testTreeMap() {
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("Name", "Nick");
        treeMap.put("Age", "18");
        treeMap.put("Now", "Lock down in SH");
        treeMap.put("Now", "Lock down in SH");
        treeMap.put("Now", "Lock down in SH");
        System.out.println(treeMap.get("Name") + ", " + treeMap.get("Age"));
        treeMap.traversal(new Map.Visitor<String, String>() {

            @Override
            public boolean visit(String key, String value) {
                System.out.println(key + ", " + value);
                return false;
            }
        });

    }

    public static void testStringMap(TreeMap<String, Integer> map, String[] words) {
        for(String word : words) {
            if (!map.containsKey(word)) {
                map.put(word, 1);
            } else {
                map.put(word, map.get(word) + 1);
            }
            Integer count = map.get(word);
            count = (count == null) ? 1 : count + 1;
            map.put(word, count);
        }

        System.out.println("Words: " + map.size());
        map.traversal(new Map.Visitor<String, Integer>() {

            @Override
            public boolean visit(String key, Integer value) {
                System.out.println(">>> " + key + ": " + value);
//                if (value.equals("currentTimeMillis")) return true;
                return false;
            }
        });
//        System.out.println("Times of class showing up: " + map.get("class"));
//        System.out.println("Times of public showing up: " + map.get("public"));
    }


    public static void testReadFile() {
        FileInfo files = Files.read("/Users/lydia/Documents/repo/algorithm", new String[]{"java"});
        System.out.println("File: " + files.getFiles());
        System.out.println("Lines: " + files.getLines());
        System.out.println("Words: " + files.words().length);
        String[] words = files.words();
        TreeMap<String, Integer> map = new TreeMap<>();
        for (String word : words) {
            if (!map.containsKey(word)) {
                map.put(word, 1);
            } else {
                map.put(word, map.get(word) + 1);
            }
            Integer count = map.get(word);
            count = (count == null) ? 1 : count + 1;
            map.put(word, count);
        }

        System.out.println("Words: " + map.size());
        map.traversal(new Map.Visitor<String, Integer>() {

            @Override
            public boolean visit(String key, Integer value) {
//                System.out.println(">>> " + key + ": " + value);
//                if (value.equals("currentTimeMillis")) return true;
                return false;
            }
        });
        System.out.println("Times of class showing up: " + map.get("class"));
        System.out.println("Times of public showing up: " + map.get("public"));

    }

    public static void testTreeSet() {
        Set<Integer> treeSet = new TresSet<>();
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(3);
        treeSet.add(2);
        System.out.println("Tree size: " + treeSet.size());
        treeSet.traversal(new Set.Visitor<Integer>() {
            @Override
            public boolean visit(Integer element) {
                System.out.println("Ele: " + element);
                return false;
            }
        });
    }

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

        return 0;
    }

    public static void testMagicNumber() {
        int[] nums = new int[]{10, 11, 21, 34};
        for (int i: nums) {
            System.out.println((31 * i) + " " + ((i << 5) - i));
        }
    }


    public static void main(String[] args) {
//        testTreeMap();
//        testReadFile();
//        testTreeSet();
//        testFloatToInt();
        testMagicNumber();
    }


}
