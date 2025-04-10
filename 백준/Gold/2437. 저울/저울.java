import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

    static int[] ch;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        ch = new int[N];

        for (int i = 0; i < N; i++) {
            ch[i] = input.nextInt();
        }
        Arrays.sort(ch);

        int answer = 1;
        for(int i = 0 ;i<N; i++) {
            if(ch[i] > answer) {
                break;
            }
            answer += ch[i];
        }

        System.out.println(answer);
    }
}
