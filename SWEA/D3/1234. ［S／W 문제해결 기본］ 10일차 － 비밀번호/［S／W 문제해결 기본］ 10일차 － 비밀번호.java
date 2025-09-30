import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        for (int T = 1; T <= 10; T++) {
            int length = input.nextInt();
            String numbers = input.next();

            int removeCount = 1;

            while (removeCount != 0) {
                int startIdx = 0;
                removeCount = 0;

                for (int i = 1; i < numbers.length(); i++) {
                    if (numbers.charAt(startIdx) == numbers.charAt(i)) {
                        removeCount++;
                        numbers = numbers.substring(0, startIdx) + numbers.substring(i + 1);
                        break;
                    }

                    startIdx++;
                }
            }

            System.out.println("#" + T + " " + numbers);
        }
    }
}
