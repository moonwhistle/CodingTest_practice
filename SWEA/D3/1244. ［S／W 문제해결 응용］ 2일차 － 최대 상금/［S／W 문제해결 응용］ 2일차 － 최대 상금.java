import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    static int max = Integer.MIN_VALUE;
    static Set<String> visited;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();

        for (int test = 1; test <= T; test++) {
            String number = input.next();
            int changeCount = input.nextInt();
            max = Integer.MIN_VALUE;
            visited = new HashSet<>();
            btk(number.toCharArray(), changeCount, 0);

            System.out.println("#" + test + " " + max);
        }
    }

    private static void btk(char[] number, int changeCount, int nowCount) {
        String now = new String(number) + nowCount;

        if (visited.contains(now)) {
            return;
        }

        visited.add(now);

        if (nowCount == changeCount) {
            max = Math.max(max, makeNumber(number));
            return;
        }

        for (int i = 0; i < number.length - 1; i++) {
            for (int j = i + 1; j < number.length; j++) {
                swap(i, j, number);
                btk(number, changeCount, nowCount + 1);
                swap(j, i, number);
            }
        }
    }

    private static void swap(int i, int j, char[] number) {
        char tmp = number[i];
        number[i] = number[j];
        number[j] = tmp;
    }

    private static int makeNumber(char[] number) {
        return Integer.parseInt(new String(number));
    }
}
