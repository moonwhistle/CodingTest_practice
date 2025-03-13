import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt(); // 정점의 개수
        int M = input.nextInt(); // 간선의 개수
        visited = new boolean[N + 1];
        graph = new ArrayList[N + 1];

        // 세팅
        for (int i = 1; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int start = input.nextInt();
            int end = input.nextInt();
            graph[start].add(end);
            graph[end].add(start);
        }

        //dfs
        for (int i = 1; i < N + 1; i++) {
            if (!visited[i]) {
                count++;
                dfs(i);
            }
        }

        System.out.println(count);
    }

    private static void dfs(int start) {
        if (visited[start]) {
            return;
        }
        visited[start] = true;

        for (Integer end : graph[start]) {
            if (!visited[end]) {
                dfs(end);
            }
        }
    }
}
