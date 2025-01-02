import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static List<List<Integer>> data = new ArrayList<>();
    static boolean[] visitedDfs;
    static boolean[] visitedBfs;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int M = input.nextInt();
        int start = input.nextInt();

        visitedDfs = new boolean[N + 1];
        visitedBfs = new boolean[N + 1];

        //dfs 초기화
        for (int i = 0; i < N + 1; i++) {
            data.add(new ArrayList<>());
        }

        //데이터 세팅
        for (int i = 0; i < M; i++) {
            int first = input.nextInt();
            int second = input.nextInt();
            data.get(first).add(second);
            data.get(second).add(first);
        }

        //데이터 정렬
        for (int i = 0; i < N + 1; i++) {
            Collections.sort(data.get(i));
        }

        DFS(start);
        System.out.print(System.lineSeparator());
        BFS(start);
    }

    private static void BFS(int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        visitedBfs[i] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int num : data.get(current)) {
                if (!visitedBfs[num]) {
                    queue.add(num);
                    visitedBfs[num] = true;
                }
            }
        }
    }

    private static void DFS(int i) {
        if (!visitedDfs[i]) {
            visitedDfs[i] = true;
            System.out.print(i + " ");
            for (int num : data.get(i)) {
                if (!visitedDfs[num]) {
                    DFS(num);
                }
            }
        }
    }
}
