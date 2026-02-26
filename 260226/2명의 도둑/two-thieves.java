import java.util.Scanner;

public class Main {

    static int n;
    static int m;
    static int c;
    static int[][] grid;
    static int max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        c = sc.nextInt();
        grid = new int[n][n];
        max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        // Please write your code here.
        findMax();
        System.out.println(max);
    }

    private static void findMax() {
        for (int y = 0; y < n; y++) {
            for (int x1 = 0; x1 <= n - m; x1++) {
                int[] nums1 = getNums(y, x1);
                int sum1 = subsetMax(nums1, 0, 0, 0);

                if (n - x1 + 1 >= m) {
                    for (int x2 = x1 + m; x2 <= n - m; x2++) {
                        int[] nums2 = getNums(y, x2);
                        int sum2 = subsetMax(nums2, 0, 0, 0);

                        // 갱신
                        max = Math.max(max, sum1 + sum2);
                    }
                }

                for (int ny = y + 1; ny < n; ny++) {
                    for (int x3 = 0; x3 <= n - m; x3++) {
                        int[] nums2 = getNums(ny, x3);
                        int sum2 = subsetMax(nums2, 0, 0, 0);

                        // 갱신
                        max = Math.max(max, sum1 + sum2);
                    }
                }
            }
        }
    }

    private static int subsetMax(int[] nums, int idx, int w, int v) {
        if (w > c) {
            return 0;
        }

        if (nums.length == idx) {
            return v;
        }

        int one = subsetMax(nums, idx + 1, w, v);
        int two = subsetMax(nums, idx + 1, w + nums[idx], v + nums[idx] * nums[idx]);

        return Math.max(one, two);
    }

    private static int[] getNums(int y, int x) {
        int[] nums = new int[m];

        for (int i = x; i < x + m; i++) {
            nums[i - x] = grid[y][i];
        }

        return nums;
    }
}
