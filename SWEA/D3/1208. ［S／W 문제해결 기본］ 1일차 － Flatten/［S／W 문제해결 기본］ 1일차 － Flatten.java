import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        for (int i = 1; i <= 10; i++) {
            int[] buildings = new int[100];
            int count = input.nextInt();

            for (int j = 0; j < 100; j++) {
                buildings[j] = input.nextInt();
            }
            Arrays.sort(buildings);

            int cnt = 0;
            while (cnt < count) {
                buildings[0]++;
                buildings[99]--;

                Arrays.sort(buildings);
                cnt++;
            }

            System.out.println("#" + i + " " + (buildings[99] - buildings[0]));
        }
    }
}
