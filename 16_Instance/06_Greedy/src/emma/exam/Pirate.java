package emma.exam;

import java.util.Arrays;

public class Pirate {
    public static void main(String[] args) {
        int[] weights = {3, 5, 4, 10, 7, 14, 2, 11};
        Arrays.sort(weights);
        int capacity = 30, weight = 0, count = 0;
        for (int i = 0; i < weights.length; i++) {
            int nWeight = weight + weights[i];
            if (nWeight <= capacity) {
                weight = nWeight;
                count++;
                System.out.println(weights[i]);
            } else {
                break;
            }
        }
        System.out.println(count + " Selected");
    }
}
