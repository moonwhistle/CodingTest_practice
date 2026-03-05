import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int m;
    static int[] A;
    static Deque<Integer> dq;
    static int max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        dq = new ArrayDeque<>();
        max = Integer.MIN_VALUE;
        // Please write your code here.
        btk(0);
        System.out.println(max);
    }

    private static void btk(int idx) {
        if(dq.size() == m) {
            int sum = 0;

            for(int d : dq) {
                sum ^= d;
            }

            max = Math.max(sum, max);

            return;
        }

        for(int i = idx; i < n; i++) {
            dq.offer(A[i]);
            btk(i + 1);
            dq.removeLast();
        }
    }
}