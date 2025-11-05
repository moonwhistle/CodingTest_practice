import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();

        for (int i = 1; i < T + 1; i++) {
            int A = input.nextInt();
            int B = input.nextInt();
            int C = input.nextInt();
            int cnt = 0;

            if (C < 3 || B < 2) {
                System.out.println("#" + i + " " + -1);
            } else {
                while (B >= C) {
                    B--;
                    cnt++;
                }
                while (A >= B) {
                    A--;
                    cnt++;
                }
                System.out.println("#" + i + " " + cnt);
            }
        }
    }
}
