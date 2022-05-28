package emma;

public class Main {
    public static void main(String[] args) {
        int[] list = {9,3,4,5,6,8,88,45,2};
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = i + 1; j < list.length; j++) {
                if (list[i] > list[j]) {
                    int temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
            }
        }
        for (int i = 0; i < list.length; i++) {
            System.out.print(" " + list[i]);
        }
//        System.out.println("Sorting list: " + list.toString());
    }
}
