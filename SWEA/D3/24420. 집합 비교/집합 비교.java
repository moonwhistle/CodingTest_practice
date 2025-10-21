import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();

        for (int test = 1; test <= T; test++) {
            int A = input.nextInt();
            int B = input.nextInt();
            List<Integer> a = new ArrayList<>();
            List<Integer> b = new ArrayList<>();

            for (int i = 0; i < A; i++) {
                a.add(input.nextInt());
            }

            for (int i = 0; i < B; i++) {
                b.add(input.nextInt());
            }

            if (A == B && isAllSame(a, b)) {
                System.out.println("=");
            } else if (A > B && isPartOfLast(b, a)) {
                System.out.println(">");
            } else if (A < B && isPartOfLast(a, b)) {
                System.out.println("<");
            } else {
                System.out.println("?");
            }
        }
    }

    private static boolean isAllSame(List<Integer> a, List<Integer> b) {
        Collections.sort(a);
        Collections.sort(b);

        for (int i = 0; i < a.size(); i++) {
            if (!Objects.equals(a.get(i), b.get(i))) {
                return false;
            }
        }

        return true;
    }

    private static boolean isPartOfLast(List<Integer> a, List<Integer> b) {
        for (int aElement : a) {
            if (!b.contains(aElement)) {
                return false;
            }
        }

        return true;
    }
}
