import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[] x;
    static int[] y;
    static double E;
    static PriorityQueue<Node> pq;
    static int[] node;
    static double answer;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            x = new int[N + 1];
            y = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                x[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                y[i] = Integer.parseInt(st.nextToken());
            }

            E = Double.parseDouble(br.readLine());
            pq = new PriorityQueue<>();
            setting();
            node = new int[N + 1];
            answer = 0;

            for (int i = 1; i <= N; i++) {
                node[i] = i;
            }

            while (!pq.isEmpty()) {
                Node now = pq.poll();

                if (union(now.s, now.e)) {
                    answer += (now.w * E);
                }
            }

            System.out.println("#" + t + " " + Math.round(answer));
        }
    }

    private static boolean union(int a, int b) {
        int aR = find(a);
        int bR = find(b);

        if (aR == bR) {
            return false;
        }

        node[bR] = aR;
        return true;
    }

    private static int find(int a) {
        if (a != node[a]) {
            node[a] = find(node[a]);
        }

        return node[a];
    }

    private static void setting() {
        for (int i = 1; i < N; i++) {
            int x1 = x[i];
            int y1 = y[i];

            for (int j = i + 1; j <= N; j++) {
                int x2 = x[j];
                int y2 = y[j];

                pq.offer(new Node(i, j, dist(x1, y1, x2, y2)));
            }
        }
    }

    private static long dist(int x1, int y1, int x2, int y2) {
        long dx = x1 - x2;
        long dy = y1 - y2;

        return dx * dx + dy * dy;
    }
}

class Node implements Comparable<Node> {

    int s;
    int e;
    long w;

    public Node(int s, int e, long w) {
        this.s = s;
        this.e = e;
        this.w = w;
    }

    @Override
    public int compareTo(Node other) {
        return Long.compare(this.w, other.w);
    }
}
