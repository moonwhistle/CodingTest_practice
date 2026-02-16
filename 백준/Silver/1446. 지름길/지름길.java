import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dist;
    static List<ShortCut> shortCuts = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        dist = new int[D + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            shortCuts.add(new ShortCut(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0));
        dist[0] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int idx = now.idx;
            int w = now.w;

            if (now.w > dist[idx]) {
                continue;
            }

            if (idx + 1 <= D) {
                if (dist[idx + 1] > w + 1) {
                    dist[idx + 1] = w + 1;
                    pq.add(new Node(idx + 1, w + 1));
                }
            }

            for (ShortCut s : shortCuts) {
                if (s.s == idx && s.e <= D) {
                    if(dist[s.e] > w + s.w) {
                        dist[s.e] = w + s.w;
                        pq.add(new Node(s.e, w + s.w));
                    }
                }
            }
        }

        System.out.println(dist[D]);
    }
}

class Node implements Comparable<Node> {
    int idx;
    int w;

    public Node(int idx, int w) {
        this.idx = idx;
        this.w = w;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(w, other.w);
    }
}

class ShortCut {
    int s;
    int e;
    int w;

    public ShortCut(int s, int e, int w) {
        this.s = s;
        this.e = e;
        this.w = w;
    }
}
