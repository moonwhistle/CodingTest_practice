import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();

        for (int test = 1; test <= T; test++) {
            String given = input.next();
            Map<Character, Integer> number = new HashMap<>();
            boolean isSatisfied = true;

            for (int i = 0; i < given.length(); i++) {
                char now = given.charAt(i);
                number.put(now, number.getOrDefault(now, 0) + 1);

                if (number.get(now) < 2) {
                    int last = now - '0' + 1 + i;

                    if (last >= given.length()) {
                        isSatisfied = false;
                        break;
                    }

                    if (given.charAt(last) != now) {
                        isSatisfied = false;
                        break;
                    }
                } else if (number.get(now) > 2) {
                    isSatisfied = false;
                    break;
                }
            }

            if(isSatisfied) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
