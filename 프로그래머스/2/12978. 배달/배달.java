import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    
    static ArrayList[] map;
    static int[] home;

    public static int solution(int N, int[][] road, int K) {
        int answer = 0;
        map = new ArrayList[N + 1];
        home = new int[N + 1];

        //세팅
        for (int i = 1; i < N + 1; i++) {
            map[i] = new ArrayList<>();
        }
        //집 연결
        for (int[] home : road) {
            int start = home[0];
            int end = home[1];
            int weight = home[2];
            map[start].add(new int[]{end, weight});
            map[end].add(new int[]{start, weight});
        }
        //최단 거리 배열 세팅
        home[1] = 0;
        for (int i = 2; i < N + 1; i++) {
            home[i] = Integer.MAX_VALUE;
        }

        bfs(1);

        for(int i = 1; i<N+1; i++) {
            if(home[i] <= K) {
                answer++;
            }
        }
        return answer;
    }

    private static void bfs(int k) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(k);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int[] link : (ArrayList<int[]>) map[current]) {
                int connect = link[0];
                int weight = link[1];

                if(weight + home[current] < home[connect]) {
                    home[connect] = weight + home[current];
                    queue.add(connect);
                }
            }
        }
    }

}
