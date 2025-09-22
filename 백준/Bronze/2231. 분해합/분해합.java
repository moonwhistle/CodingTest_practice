import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String N = input.next();
        int min = Integer.MAX_VALUE;

        int len = N.length();
        int start = Integer.parseInt(N) - (9 * len);

        if (start < 0) {
            start = 0;
        }

        for (int i = start; i < Integer.parseInt(N); i++) {
            String num = String.valueOf(i);
            int sum = i;

            for (int j = 0; j < num.length(); j++) {
                sum += num.charAt(j) - '0';
            }

            if (sum == Integer.parseInt(N)) {
                min = Math.min(min, i);
            }
        }

        if(min == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(min);
        }
    }
}
