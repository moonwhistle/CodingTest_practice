import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        for (int i = 1; i <= 10; i++) {
            int N = input.nextInt();
            int[] buildings = new int[N];

            for (int j = 0; j < N; j++) {
                buildings[j] = input.nextInt();
            }

            System.out.println("#" + i + " " + goodBuildings(buildings));
        }
    }

    private static int goodBuildings(int[] buildings) {
        int result = 0;

        for (int i = 2; i < buildings.length - 2; i++) {
            int now = buildings[i];
            int left1 = buildings[i - 1];
            int left2 = buildings[i - 2];
            int right1 = buildings[i + 1];
            int right2 = buildings[i + 2];

            int minLeft = Math.min(count(now, left1), count(now, left2));
            int minRight = Math.min(count(now, right1), count(now, right2));

            result += Math.min(minLeft, minRight);
        }

        return result;
    }

    private static int count(int now, int tmp) {
        return Math.max(now - tmp, 0);

    }
}
