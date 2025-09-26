import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 10; // 항상 10개 케이스
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int ans = 0;
            for (int i = 2; i < N - 2; i++) {
                int maxH = Math.max(
                        Math.max(arr[i - 1], arr[i - 2]),
                        Math.max(arr[i + 1], arr[i + 2])
                );
                if (arr[i] > maxH) ans += arr[i] - maxH;
            }

            System.out.println("#" + test_case + " " + ans);
        }
    }
}
