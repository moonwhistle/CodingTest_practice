import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static List<Character> st;
    static List<Character> all;
    static List<Character> op;
    static int max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expression = sc.next();
        st = new ArrayList<>();
        all = new ArrayList<>();
        op = new ArrayList<>();
        max = 0;

        for (char e : expression.toCharArray()) {
            if (e == '+' || e == '-' || e == '*') {
                op.add(e);
                continue;
            }

            all.add(e);

            if (st.contains(e)) {
                continue;
            }

            st.add(e);
        }

        btk(st.size(), new HashMap<>(), 0);
        System.out.println(max);
    }

    private static void btk(int size, Map<Character, Integer> map, int idx) {
        if (size == map.size()) {
            int result = map.get(all.get(0));

            for (int i = 1; i < all.size(); i++) {
                result = cal(op.get(i-1), map.get(all.get(i)), result);
            }

            max = Math.max(max, result);
            return;
        }

        for (int i = 1; i <= 4; i++) {
            char num = st.get(idx);
            map.put(num, i);
            btk(size, map, idx + 1);
            map.remove(num);
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
