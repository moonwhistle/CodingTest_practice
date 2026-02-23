import java.util.Scanner;

public class Main {

    static int cnt;
    static int[] nums;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] segments = new int[n][2];
        for (int i = 0; i < n; i++) {
            segments[i][0] = sc.nextInt();
            segments[i][1] = sc.nextInt();
        }
        // Please write your code here.
        nums = new int[1001];
        cnt = 0;
        btk(n, 0, segments, 0);
        System.out.println(cnt);
    }

    private static void btk(int n, int idx, int[][] segments, int count) {
        cnt = Math.max(cnt, count);

        for(int i = idx ; i < n ; i++) {
            int[] segment = segments[i];
            int s = segment[0];
            int e = segment[1];
            boolean notContain = true;

            for(int j = s; j <= e; j++) {
                if(nums[j] > 0) {
                    notContain = false;
                    break;
                }
            }

            if(notContain) {
                count++;
                for(int j = s; j <= e; j++) {
                    nums[j]++;
                }
                btk(n, i + 1, segments, count);
                for(int j = s; j <= e; j++) {
                    nums[j]--;
                }
                count--;
            }
        }
    }
}
