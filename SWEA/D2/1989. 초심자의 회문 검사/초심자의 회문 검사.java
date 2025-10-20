import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();

        for (int i = 1; i <= T; i++) {
            String word = input.next();

            int start = 0;
            int end = word.length() - 1;
            boolean isPan = true;

            while (start < end) {
                if (word.charAt(start) != word.charAt(end)) {
                    isPan = false;
                    break;
                }

                start++;
                end--;
            }

            if (isPan) {
                System.out.println("#" + i + " " + 1);
            } else {
                System.out.println("#" + i + " " + 0);
            }
        }
    }
}
