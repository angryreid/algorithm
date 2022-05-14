package emma;

import emma.file.Files;
import emma.set.ListSet;
import emma.set.Set;
import emma.set.Set.Visitor;
import emma.set.TreeSet;
import emma.file.FileInfo;
import emma.time.Times;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void testListSet() {
        Set<Integer> listSet = new ListSet<>();
        Integer[] nums = {0,1,2,3,4,5,6,7,8,9};
        Integer[] numsRepeat = {0,1,2,3,4,5,6,7,8,9};
        for(int num : nums) {
            listSet.add(num);
        }
        for(int num : numsRepeat) {
            listSet.add(num);
        }
        listSet.traversal(new Visitor() {
            @Override
            public boolean visit(Object element) {
                System.out.print("_"+element+"_");
                return false;
            }
        });
    }

    public static void testTreeList() {
        Set<Integer> treeSet = new TreeSet<>();
        Integer[] nums = {9,8,7,6,5,4,3,2,1,0};
        for(int num : nums) {
            treeSet.add(num);
        }
        treeSet.traversal(new Visitor() {
            @Override
            public boolean visit(Object element) {
                System.out.print("_"+element+"_");
                return false;
            }
        });
    }

    public static void testStringSet(Set<String> set, String[] words) {
        for (String word : words) {
            set.add(word);
        }
        for (String word : words) {
            set.contains(word);
        }
        for (String word : words) {
            set.remove(word);
        }
    }

    public static void testReadFile() {
        FileInfo files = Files.read("/Users/lydia/Documents/repo/algorithm", new String[]{"java"});
        System.out.println("File: " + files.getFiles());
        System.out.println("Lines: " + files.getLines());
        System.out.println("Words: " + files.words().length);
        String[] words = files.words();
        List<String> newWords = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < words.length; j++) {
                newWords.add(words[j]);
            }
        }
        String[] wordsTimes = newWords.toArray(new String[newWords.size()]);
        Times.test("Test ListSet", new Times.Task() {
            @Override
            public void execute() {
                testStringSet(new ListSet<>(), wordsTimes);
            }
        });

        Times.test("Test TreeSet", new Times.Task() {
            @Override
            public void execute() {
                testStringSet(new TreeSet<>(), wordsTimes);
            }
        });
    }

    public static void main(String[] args) {
//        testListSet();
//        testTreeList();
        testReadFile();
    }

}
