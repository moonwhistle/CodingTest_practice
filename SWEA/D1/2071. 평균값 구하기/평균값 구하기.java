import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int test = input.nextInt();

        for (int i = 1; i <= test; i++) {
            int sum = 0;

            for (int j = 0; j < 10; j++) {
                int num = input.nextInt();
                sum += num;
            }

            sum = (int) Math.round(sum / 10.0);

            System.out.println("#" + i + " " + sum);
        }
    }
}
