import java.util.Arrays;

class Solution {

    static boolean[] visited;

    public static void main(String[] args) {
        solution(3, new int[][]{{1, 1, 0}, {1, 0, 1}});
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];

        for(int i = 0; i< computers.length; i++) {
            if(!visited[i]) {
                answer++;
                dfs(computers, i);
            }
        }
        
        return answer;
    }

    private static void dfs(int[][] computers, int i) {
        visited[i] = true;

        for(int j = 0 ;j <computers.length; j++) {
            if(computers[i][j] == 1 && !visited[j] ) {
                dfs(computers, j);
            }
        }
    }
}
