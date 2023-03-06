package emma.exam;

import java.util.Arrays;

public class Coin {
    public static void main(String[] args) {
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
}
