import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();

        String S = input.next();

        int sum = 0;

        for(int i=0;i<S.length();i++)
        {
            char c = S.charAt(i);
            int x = c-48;
            sum += x;
        }

        System.out.println(sum);
    }
}