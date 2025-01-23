import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int[] visitCount;
    static ArrayList[] graph;

    public static int solution(int n, int[][] edge) {
        int answer = 0;

        visitCount = new int[n + 1];
        for (int i = 2; i < n + 1; i++) {
            visitCount[i] = Integer.MAX_VALUE;
        }

        //인접리스트 세팅
        graph = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int[] e : edge) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        bfs();

        int max = 0;
        for (int i : visitCount) {
            if (i > max) {
                max = i;
            }
        }

        for (int i = 1; i < n + 1; i++) {
            if (visitCount[i] == max) {
                answer++;
            }
        }
        return answer;
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (Object other : graph[current]) {
                int next = (int) other;
                int wight = 1;
                if (visitCount[current] + wight < visitCount[next]) {
                    visitCount[next] = visitCount[current] + wight;
                    queue.add(next);
                }

            }
        }
    }
}