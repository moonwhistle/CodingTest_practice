import java.util.Scanner;

public class Solution {

    static int max;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();

        for (int i = 0; i < T; i++) {
            String line = input.next();
            max = 0;
            int location = 0;

            for (char lineElement : line.toCharArray()) {
                if (String.valueOf(lineElement).equals("L")) {
                    location -= 1;
                } else if (String.valueOf(lineElement).equals("R")) {
                    location += 1;
                } else {
                    location -= 1;
                }

                max = Math.max(max, Math.abs(location));
            }

            location = 0;
            for (char lineElement : line.toCharArray()) {
                if (String.valueOf(lineElement).equals("L")) {
                    location -= 1;
                } else if (String.valueOf(lineElement).equals("R")) {
                    location += 1;
                } else {
                    location += 1;
                }

                max = Math.max(max, Math.abs(location));
            }

            System.out.println(max);
        }
    }
}
