import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static boolean[] visitedDfs;
    static boolean[] visitedBfs;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int M = input.nextInt();
        int V = input.nextInt();

        visitedDfs = new boolean[N + 1];
        visitedBfs = new boolean[N + 1];

        ArrayList<Integer>[] map = new ArrayList[N + 1];

        for(int i = 1 ; i<N + 1; i++) {
            map[i] = new ArrayList<>();
        }

        for(int i = 0; i<M; i++) {
            int start = input.nextInt();
            int end = input.nextInt();

            map[start].add(end);
            map[end].add(start);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(map[i]);
        }

        dfs(V, map);
        System.out.println();
        bfs(V, map);
    }

    private static void dfs(int V, ArrayList<Integer>[] map) {
        if(visitedDfs[V]) {
            return;
        }

        visitedDfs[V] = true;
        System.out.print(V + " ");

        for(int i : map[V]) {
            dfs(i, map);
        }
    }

    private static void bfs(int V, ArrayList<Integer>[] map) {
        Queue<Integer> queue = new LinkedList<>();

        visitedBfs[V] = true;
        queue.add(V);

        while(!queue.isEmpty()) {
            int num = queue.poll();
            System.out.print(num + " ");

            for(int next : map[num]) {
                if(!visitedBfs[next]) {
                    visitedBfs[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}
