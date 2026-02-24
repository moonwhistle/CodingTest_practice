import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Character> expressions;
    static int max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expression = sc.next();
        expressions = new ArrayList<>();
        max = Integer.MIN_VALUE;

        for (char ex : expression.toCharArray()) {
            if (ex == '+' || ex == '-' || ex == '*') {
                expressions.add(ex);
            }
        }

        int size = expression.length() - expressions.size();
        btk(size, new ArrayList<>());
        System.out.println(max);
    }

    private static void btk(int size, List<Integer> box) {
        if (size == box.size()) {
            int result = box.get(0);
            int i = 1;
            int j = 0;

            while (i < size) {
                result = cal(expressions.get(j), box.get(i), result);
                i++;
                j++;
            }

            max = Math.max(max, result);
            return;
        }

        for (int i = 1; i <= 4; i++) {
            box.add(i);
            btk(size, box);
            box.remove(box.size() - 1);

        }
    }

    private static int cal(char op, int num, int result) {
        if (op == '+') {
            return result + num;
        } else if (op == '-') {
            return result - num;
        } else {
            return result * num;
        }
    }
}
