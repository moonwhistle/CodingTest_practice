import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String N = input.next();
        int size = N.length();
        int start = Integer.parseInt(N) - size * 9;

        if(start < 0) {
            start = 0;
        }

        int min = Integer.MAX_VALUE;
        for(int i = start ; i<Integer.parseInt(N); i++) {
            int len = String.valueOf(i).length();
            int sum = i;

            for(int j = 0; j < len; j++) {
                sum += String.valueOf(i).charAt(j) - '0';
            }

            if(sum == Integer.parseInt(N)) {
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
