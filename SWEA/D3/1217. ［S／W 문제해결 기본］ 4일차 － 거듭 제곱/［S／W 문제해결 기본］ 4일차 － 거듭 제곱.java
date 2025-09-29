import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        for (int test = 0; test < 10; test++) {
            int testNumber = input.nextInt();

            int number = input.nextInt();
            int count = input.nextInt();

            System.out.println("#" + testNumber + " " + btk(number, count, 0, 1));
        }
    }

    private static int btk(int number, int targetCount, int count, int sum) {
        if (count == targetCount) {
            return sum;
        }

        return btk(number, targetCount, count + 1, sum * number);
    }
}
