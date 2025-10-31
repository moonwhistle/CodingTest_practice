import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    static ArrayList<Integer>[] map;
    static boolean[] visited;
    static List<Node> nodes;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        for (int i = 1; i < 11; i++) {
            int inputSize = input.nextInt();
            int start = input.nextInt();

            map = new ArrayList[101];
            visited = new boolean[101];
            nodes = new ArrayList<>();
            initMap();

            for (int j = 0; j < inputSize / 2; j++) {
                int st = input.nextInt();
                int end = input.nextInt();

                map[st].add(end);
            }

            bfs(start);
            Collections.sort(nodes);

            System.out.println("#" + i + " " + nodes.get(0).number());
        }
    }

    private static void bfs(int start) {
        Node st = new Node(start, 0);
        Queue<Node> queue = new LinkedList<>();
        queue.add(st);
        nodes.add(st);
        visited[start] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int num = now.number();
            int depth = now.depth();

            for (int i : map[num]) {
                if (!visited[i]) {
                    Node newNode = new Node(i, depth + 1);
                    visited[i] = true;
                    queue.add(newNode);
                    nodes.add(newNode);
                }
            }
        }
    }

    private static void initMap() {
        for (int i = 1; i < 101; i++) {
            map[i] = new ArrayList<>();
        }
    }
}

class Node implements Comparable<Node> {

    private final int number;
    private final int depth;

    Node(int number, int depth) {
        this.number = number;
        this.depth = depth;
    }

    public int number() {
        return number;
    }

    public int depth() {
        return depth;
    }

    @Override
    public int compareTo(Node other) {
        if (depth == other.depth) {
            return other.number - this.number;
        }

        return other.depth - this.depth;
    }
}
