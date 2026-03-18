import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int M;
    static int X;
    static ArrayList<int[]>[] list;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        list = new ArrayList[N + 1];
        nums = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[s].add(new int[]{e, w});
        }

        for (int i = 1; i <= N; i++) {
            djkstra(i, X, false);
            djkstra(X, i, true);
        }

        Arrays.sort(nums);
        System.out.println(nums[nums.length - 1]);
    }

    private static void djkstra(int s, int e, boolean isReverse) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;

        PriorityQueue<P> queue = new PriorityQueue<>();
        queue.add(new P(s, 0));

        while (!queue.isEmpty()) {
            P now = queue.poll();
            int ns = now.n;
            int w = now.w;

            if (dist[ns] < w) {
                continue;
            }

            for (int[] next : list[ns]) {
                int n = next[0];
                int nw = next[1];

                if (nw + w <= dist[n]) {
                    dist[n] = nw + w;
                    queue.add(new P(n, nw + w));
                }
            }
        }

        if (!isReverse) {
            nums[s] += dist[e];
        } else {
            nums[e] += dist[e];
        }
    }
}

class P implements Comparable<P> {

    int n;
    int w;

    public P(int n, int w) {
        this.n = n;
        this.w = w;
    }

    @Override
    public int compareTo(P o) {
        return w - o.w;
    }
}
