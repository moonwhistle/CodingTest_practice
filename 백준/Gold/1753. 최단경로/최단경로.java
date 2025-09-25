import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // setting
        int V = input.nextInt();
        int E = input.nextInt();
        int K = input.nextInt();

        List<Node>[] nodes = new ArrayList[V + 1];
        boolean[] visited = new boolean[V + 1];
        int[] distance = new int[V + 1];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[K] = 0;

        for (int i = 1; i < V + 1; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            int u = input.nextInt();
            int v = input.nextInt();
            int w = input.nextInt();

            nodes[u].add(new Node(v, w));
        }

        // bfs
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(K, 0));

        while (!queue.isEmpty()) {
            Node nowNode = queue.poll();
            int now = nowNode.to;

            visited[now] = true;

            for (Node node : nodes[now]) {
                int to = node.to;

                if (!visited[to] && distance[to] > distance[now] + node.weight) {
                    distance[to] = distance[now] + node.weight;
                    queue.add(new Node(to, distance[to]));
                }
            }
        }

        // sout
        for (int i = 1; i < V + 1; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }
    }
}

class Node implements Comparable<Node> {

    int to;
    int weight;

    public Node(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node other) {
        return this.weight - other.weight;
    }
}
