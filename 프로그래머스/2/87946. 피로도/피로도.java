class Solution {

    static int max = 0;
    static boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        visited = new boolean[dungeons.length];
        btk(k, dungeons, 0);
        answer = max;
        return answer;
    }

    private void btk(int k, int[][] dungeons, int cnt) {
        if (cnt == dungeons.length) {
            max = Math.max(cnt, max);
            return;
        }

        for (int i = 0; i < dungeons.length; i++) {
            int[] dungeon = dungeons[i];

            if (!visited[i] && k >= dungeon[0]) {
                k -= dungeon[1];
                visited[i] = true;
                btk(k, dungeons, cnt + 1);
                k += dungeon[1];
                visited[i] = false;
            } else {
                max = Math.max(cnt, max);
            }
        }
    }
}
