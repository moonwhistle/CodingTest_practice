import java.util.Scanner;
import java.util.*;

public class Main {

    static int k;
    static int n;
    static List<Integer> answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();
        answer = new ArrayList<>();
        // Please write your code here.
        btk(1, 0);
    }

    private static void btk(int num, int count) {
        if (answer.size() == n) {
            for (int i : answer) {
                System.out.print(i + " ");
            }
            System.out.println();

            return;
        }

        for (int i = 1; i <= k; i++) {
            if (num == i && count == 2) {
                continue;
            }

            if(num == i) {
                answer.add(i);
                btk(i, count + 1);
                answer.remove(answer.size() - 1);
            } else {
                answer.add(i);
                btk(i, 1);
                answer.remove(answer.size() - 1);
            }
        }
    }
}
