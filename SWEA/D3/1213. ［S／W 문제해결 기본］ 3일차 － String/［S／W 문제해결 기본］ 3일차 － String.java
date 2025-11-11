import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        for (int i = 1; i <= 10; i++) {
            int test = input.nextInt();
            String given = input.next();
            int cnt = 0;
            String line = input.next();

            // setting
            StringBuilder box = new StringBuilder();
            for (int j = 0; j < line.length(); j++) {
                box.append(line.charAt(j));

                if (box.length() == given.length()) {
                    if (box.toString().equals(given)) {
                        cnt++;
                    }

                    box.deleteCharAt(0);
                }
            }

            System.out.println("#" + test + " " + cnt);
        }
    }
}
