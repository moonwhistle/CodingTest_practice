import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int[] arr;
    static int sum;
    static int min;
    static Deque<Integer> dq;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[2 * n];
        sum = 0;
        min = Integer.MAX_VALUE;
        dq = new ArrayDeque<>();

        for (int i = 0; i < 2 * n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        // Please write your code here.
        btk(0, 0, 0);
        System.out.println(min);
    }

    private static void btk(int idx, int s, int depth) {
        if(depth == n) {
            int remain = sum - s;
            min = Math.min(min, Math.abs(remain - s));
            return;
        }

        for(int i = idx ; i < 2 * n; i++) {
            btk(i + 1, s + arr[i], depth + 1);
        }
    }
}