public class Solution {

    static boolean[] paint;
    static int[] wall;

    public static int solution(int n, int m, int[] section) {
        int answer = 0;

        wall = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            wall[i] = i;
        }

        paint = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++) {
            paint[i] = true;
        }

        for (int i : section) {
            paint[i] = false;
        }

        for (int i = 1; i < n + 1; i++) {
            if (!paint[i]) {
                answer++;
                dfs(i, m);
            }
        }

        return answer;
    }

    private static void dfs(int i, int m) {
        int end = i + m;
        if (end > wall.length) {
            end = wall.length;
        }
        
        for (int k = i; k < end; k++) {
            if (!paint[k]) {
                paint[k] = true;
            }
        }
    }
}
