import java.util.Scanner;

public class Main {

    static int cnt;
    static int[] end;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] segments = new int[n][2];
        for (int i = 0; i < n; i++) {
            segments[i][0] = sc.nextInt();
            segments[i][1] = sc.nextInt();
        }
        // Please write your code here.
        end = new int[1001];
        cnt = 0;
        btk(n, 0, segments, 0);
        System.out.println(cnt);
    }

    private static void btk(int n, int idx, int[][] segments, int count) {
        for(int i = idx ; i < n ; i++) {
            int[] segment = segments[i];

            if(end[segment[1]] != 1) {
                count++;
                end[segment[1]]++;
                cnt = Math.max(cnt, count);
                btk(n, i + 1, segments, count);
                end[segment[1]]--;
                count--;
            }
        }
    }
}