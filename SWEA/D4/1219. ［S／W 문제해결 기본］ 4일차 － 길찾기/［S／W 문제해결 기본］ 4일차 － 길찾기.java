import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    static ArrayList<Integer>[] map;
    static boolean is99 = false;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        for (int i = 1; i <= 10; i++) {
            map = new ArrayList[100];
            for (int j = 0; j < 100; j++) {
                map[j] = new ArrayList<>();
            }
            is99 = false;

            int test = input.nextInt();
            int pair = input.nextInt();

            for (int j = 0; j < pair; j++) {
                int start = input.nextInt();
                int end = input.nextInt();

                map[start].add(end);
            }

            dfs(0);

            if (is99) {
                System.out.println("#" + test + " " + 1);
            } else {
                System.out.println("#" + test + " " + 0);
            }
        }
    }

    private static void dfs(int start) {
        if (start == 99) {
            is99 = true;
            return;
        }

        for (int node : map[start]) {
            dfs(node);
        }
    }
}
