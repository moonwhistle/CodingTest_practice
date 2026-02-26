import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static ArrayList<Integer>[] cities;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        cities = new ArrayList[N + 1];
        visited = new int[N + 1];
        Arrays.fill(visited, Integer.MAX_VALUE);

        for (int i = 0; i < N + 1; i++) {
            cities[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            cities[s].add(e);
        }

        dijkstra(X, K);
    }

    private static void dijkstra(int start, int count) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        visited[start] = 0;
        q.add(new Node(start, 0));
        List<Integer> nums = new ArrayList<>();

        while (!q.isEmpty()) {
            Node node = q.poll();
            int now = node.now;
            int w = node.w;

            if (w > visited[now]) { // 넘으면 패스
                continue;
            }

            if (w == count) {
                nums.add(now);
            }

            for (int i : cities[now]) {
                if (visited[i] > w + 1) {
                    visited[i] = w + 1;
                    q.add(new Node(i, w + 1));
                }
            }
        }

        if (nums.isEmpty()) {
            System.out.println(-1);
            return;
        }

        Collections.sort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}

class Node implements Comparable<Node> {
    int now;
    int w;

    public Node(int now, int w) {
        this.now = now;
        this.w = w;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(w, other.w);
    }
}
