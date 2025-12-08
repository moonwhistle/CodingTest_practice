import java.util.ArrayList;

class Solution {

    static ArrayList<Integer>[] map;
    static boolean[] visited;

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        map = new ArrayList[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[i].length; j++) {
                if (j == i) {
                    continue;
                }

                if (computers[i][j] == 1) {
                    map[i].add(j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                dfs(i);
            }
        }

        return answer;
    }

    private static void dfs(int start) {
        visited[start] = true;

        for (int element : map[start]) {
            if (!visited[element]) {
                dfs(element);
            }
        }
    }
}
