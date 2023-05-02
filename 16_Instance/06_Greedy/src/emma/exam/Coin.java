package emma.exam;

import java.util.Arrays;

public class Coin {
    public static void main(String[] args) {
        Integer[] faces = {25, 10, 5, 1};
        Arrays.sort(faces, (Integer f1, Integer f2) -> f2 - f1);
        int money = 41, coins = 0, i = 0;
        while (i < faces.length) {
            if (money < faces[i]) {
                i++;
                continue;
            }

            System.out.println(faces[i]);
            money -= faces[i];
            coins++;
        }
        System.out.println(coins);

        coinChange2();
    }

    static void coinChange() {
        int[] faces = {25, 10, 5, 1};
        Arrays.sort(faces);
        int money = 41, coins = 0;
        for (int i = faces.length - 1; i >= 0 ; i--) {
            if (money < faces[i]) continue;

            System.out.println(faces[i]);
            money -= faces[i];
            coins++;
            i = faces.length;
        }
        System.out.println(coins);
    }

    static void coinChange2() {
        int[] faces = {25, 10, 5, 1};
        Arrays.sort(faces);
        int money = 41, coins = 0, idx = faces.length - 1;
        while (idx >= 0) {
            while (money >= faces[idx]) {
                money -= faces[idx];
                coins++;
            }
            idx--;
        }

        System.out.println(coins);
    }

}
