import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = 10;

        for (int i = 0; i < T; i++) {
            int testNumber = input.nextInt();

            String target = input.next();
            String line = input.next();

            int sum = 0;

            for (int j = 0; j <= line.length() - target.length(); j++) {
                if (target.charAt(0) == line.charAt(j)) {
                    int end = j + target.length();

                    if (line.substring(j, end).equals(target)) {
                        sum++;
                    }
                }
            }

            System.out.println("#" + testNumber + " " + sum);
        }
    }
}
