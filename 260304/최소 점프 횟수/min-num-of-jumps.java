import java.util.*;

public class Main {

    static int n;
    static int[] arr;
    static int min;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.
        btk(0, 0);

        if(min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }

    private static void btk(int idx, int count) {
        if(idx == n-1) {
            min = Math.min(min, count);
            return;
        }

        if(idx >= n) {
            return;
        }

        int plus = arr[idx];

        for(int i = idx + 1; i < idx + plus + 1; i++) {
            btk(i, count + 1);
        }
    }
}
