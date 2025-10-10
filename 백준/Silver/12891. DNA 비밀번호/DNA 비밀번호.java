import java.util.Scanner;

public class Main {

    private static int passwordCount = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // setting
        int S = input.nextInt();
        int P = input.nextInt();

        String password = input.next();
        int[] count = new int[4];

        for (int i = 0; i < 4; i++) {
            count[i] = input.nextInt();
        }

        // 처음 주어진 개수 비교
        int[] currentCount = new int[4];

        for(int i = 0 ; i<P; i++) {
            currentCount[getIndex(password.charAt(i))]++;
        }

        countPassword(count, currentCount);

        // 이동하며 비교
        for(int i = P; i< password.length(); i++) {
            char first = password.charAt(i - P);
            char last = password.charAt(i);

            currentCount[getIndex(first)]--;
            currentCount[getIndex(last)]++;

            countPassword(count, currentCount);
        }

        System.out.println(passwordCount);
    }

    private static void countPassword(int[] count, int[] currentCount) {
        boolean isPassword = true;

        for (int i = 0; i < 4; i++) {
            if (count[i] > currentCount[i]) {
                isPassword = false;
            }
        }

        if (isPassword) {
            passwordCount++;
        }
    }

    private static int getIndex(char c) {
        if (c == 'A') {
            return 0;
        }
        if (c == 'C') {
            return 1;
        }
        if (c == 'G') {
            return 2;
        }
        if (c == 'T') {
            return 3;
        }
        
        return -1;
    }
}
