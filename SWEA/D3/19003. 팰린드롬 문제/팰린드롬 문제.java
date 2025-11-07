import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

    static int maxLength;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();

        for (int i = 1; i <= T; i++) {
            int N = input.nextInt();
            int M = input.nextInt();
            maxLength = 0;
            List<String> pal = new ArrayList<>();
            List<String> notPal = new ArrayList<>();

            for (int j = 0; j < N; j++) {
                String s = input.next();

                if (isPalindrome(s)) {
                    pal.add(s);
                } else {
                    notPal.add(s);
                }
            }

            for (String s : notPal) {
                String reverse = reverse(s);

                if (notPal.contains(reverse)) {
                    maxLength += reverse.length();
                }
            }

            if (!pal.isEmpty()) {
                maxLength += M;
            }

            System.out.println("#" + i + " " + maxLength);
        }
    }

    private static String reverse(String s) {
        return new StringBuilder(s).reverse()
                .toString();
    }

    private static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}
