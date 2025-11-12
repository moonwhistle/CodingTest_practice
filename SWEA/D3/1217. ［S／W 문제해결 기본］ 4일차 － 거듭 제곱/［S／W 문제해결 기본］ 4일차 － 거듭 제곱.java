import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        for (int i = 1; i <= 10; i++) {
            int test = input.nextInt();

            int num = input.nextInt();
            int count = input.nextInt();

            int answer = btk(num, count, 0, 1);
            System.out.println("#" + test + " " + answer);
        }
    }

    private static int btk(int num, int count, int nowCount, int sum) {
        if (nowCount == count) {
            return sum;
        }

        sum = btk(num, count, nowCount + 1, sum * num);

        return sum;
    }
}
