import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static int[] count;

    public static int solution(int[][] land) {
        int answer = 0;

        //방문 배열 초기화
        visited = new boolean[land.length][land[0].length];

        count = new int[land[0].length];

        // 가로 길이만큼 반복
        for (int i = 0; i < land[0].length; i++) {
            for(int j = 0; j<land.length; j++) {
                if(!visited[j][i] && land[j][i] == 1) {
                    bfs(land, j, i);
                }
            }
        }

        for(int i : count) {
            answer = Math.max(answer, i);
        }

        return answer;
    }

    private static void bfs(int[][] land, int row, int column) {
        Queue<int[]> locations = new LinkedList<>();
        locations.offer(new int[]{row, column});
        Set<Integer> duplicatedColumn = new HashSet<>();
        duplicatedColumn.add(column);
        int cnt = 1;
        visited[row][column] = true;

        while (!locations.isEmpty()) {
            int[] location = locations.poll();
            int y = location[0];
            int x = location[1];

            for (int i = 0; i < dx.length; i++) {
                int nowY = y + dy[i];
                int nowX = x + dx[i];

                if (nowX >= 0 && nowY >= 0 && nowX < land[0].length && nowY < land.length) {
                    if (!visited[nowY][nowX] && land[nowY][nowX] == 1) {
                        visited[nowY][nowX] = true;
                        duplicatedColumn.add(nowX);
                        cnt++;
                        locations.offer(new int[]{nowY, nowX});
                    }
                }
            }
        }

        for(int i : duplicatedColumn) {
            count[i] += cnt;
        }
    }
}
