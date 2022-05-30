package emma;

public class Main {
    public static void main(String[] args) {
        int[] list = {9, 3, 4, 2, 5, 6, 8, 88, 45, 2, 2, 2};
        for (int i = 0; i < list.length; i++) {
            for (int j = 1; j < list.length - i; j++) {
                if (list[j] < list[j - 1]) {
                    int temp = list[j];
                    list[j] = list[j - 1];
                    list[j - 1] = temp;
                }
            }
        }

        // After sorted
        for (int i = 0; i < list.length; i++) {
            System.out.print(" " + list[i]);
        }
//        System.out.println("Sorting list: " + list.toString());
    }
}
