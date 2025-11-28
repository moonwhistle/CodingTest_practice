import java.util.ArrayList;

class Solution {

    static ArrayList<Integer>[] map;
    static boolean[] visited;
    static int cnt;

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        map = new ArrayList[n + 1];

        for (int i = 1; i < n + 1; i++) {
            map[i] = new ArrayList<>();
        }

        for (int[] wire : wires) {
            int start = wire[0];
            int end = wire[1];

            map[start].add(end);
            map[end].add(start);
        }

        for (int[] wire : wires) {
            int start = wire[0];
            int end = wire[1];
            visited = new boolean[n + 1];
            cnt = 1;
            dfs(1, start, end);
            int minus = Math.abs(cnt - (n - cnt));
            answer = Math.min(minus, answer);
        }

        return answer;
    }

    private void dfs(int node, int start, int end) {
        visited[node] = true;

        for (int next : map[node]) {
            if ((node == start && next == end) || (node == end && next == start)) {
                continue;
            }

            if (!visited[next]) {
                cnt++;
                dfs(next, start, end);
            }
        }
    }
}
