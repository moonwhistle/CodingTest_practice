import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int M;
    static PriorityQueue<Node> pq;
    static int[] node;
    static int count;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        node = new int[N + 1];
        pq = new PriorityQueue<>();
        count = 0;

        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            pq.add(new Node(s, e, w));
        }

        makeSet();

        while(!pq.isEmpty()) {
            Node now = pq.poll();
            int s = now.s;
            int e = now.e;
            int w = now.w;

            if(union(s, e)) {
                count += w;
            }
        }

        System.out.println(count);
    }

    private static boolean union(int a, int b) {
        int aR = find(a);
        int bR = find(b);

        if(aR == bR) {
            return false;
        }

        node[bR] = aR;
        return true;
    }

    private static int find(int a) {
        if(a != node[a]) {
            node[a] = find(node[a]);
        }

        return node[a];
    }

    private static void makeSet() {
        for(int i = 1 ; i <= N; i++) {
            node[i] = i;
        }
    }
}

class Node implements Comparable<Node> {

    int s;
    int e;
    int w;

    public Node(int s, int e, int w) {
        this.s = s;
        this.e = e;
        this.w = w;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.w, other.w);
    }
}
