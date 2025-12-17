import java.util.ArrayList;

class Solution {

    static ArrayList<Integer>[] map;
    static boolean[] visited;
    static int cnt;

    public static int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        setMap(n, wires);

        for (int[] wire : wires) {
            visited = new boolean[n + 1];
            cnt = 0;
            dfs(wire[0], wire[1]);
            answer = Math.min(Math.abs(n - cnt - cnt), answer);
        }

        return answer;
    }

    private static void dfs(int start, int ignore) {
        cnt++;
        visited[start] = true;

        for (int element : map[start]) {
            if (element == ignore) {
                continue;
            }
            if (!visited[element]) {
                dfs(element, ignore);
            }
        }
    }

    private static void setMap(int n, int[][] wires) {
        map = new ArrayList[n + 1];

        for (int i = 0; i < n + 1; i++) {
            map[i] = new ArrayList<>();
        }

        for (int[] wire : wires) {
            map[wire[0]].add(wire[1]);
            map[wire[1]].add(wire[0]);
        }
    }
}
