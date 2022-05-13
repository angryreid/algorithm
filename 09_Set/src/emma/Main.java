package emma;

import emma.set.ListSet;
import emma.set.Set;
import emma.set.Set.Visitor;

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

    public static void main(String[] args) {
        testListSet();
    }
}
