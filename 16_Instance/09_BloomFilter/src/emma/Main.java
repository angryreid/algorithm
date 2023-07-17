package emma;

public class Main {
    public static void main(String[] args) {
        BloomFilter<Integer> bf = new BloomFilter<>(1_00_0000, 0.01);
//        for (int i = 0; i < 500; i++) {
//            bf.put(i);
//        }
//        for (int i = 0; i < 500; i++) {
//            System.out.println(bf.contains(i));
//        }
        long count = 0;
        for (int i = 0; i < 1_00_0000; i++) {
            bf.put(i);
        }
        for (int i = 1_00_0001; i < 2_00_0000; i++) {
            if(bf.contains(i)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
