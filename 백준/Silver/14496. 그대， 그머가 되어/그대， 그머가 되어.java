import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int a;
    static int b;
    static int N;
    static int M;
    static int[] nums;
    static ArrayList<Integer>[] list;
    
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N + 1];
        Arrays.fill(nums, Integer.MAX_VALUE);
        list = new ArrayList[N + 1];

        for(int i = 0 ; i <= N ; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list[s].add(e);
            list[e].add(s);
        }

        djkstra();

        if(nums[b] == Integer.MAX_VALUE) {
            System.out.println(-1); 
        } else {
            System.out.println(nums[b]); 
        }
    }

    private static void djkstra() {
        nums[a] = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(a, 0));

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int n = node.n;
            int w = node.w;

            if(nums[n] < w) {
                continue;
            }

            for(int i : list[n]) {
                int ww = w + 1;
                
                if(ww < nums[i]) {
                    nums[i] = ww;
                    queue.add(new Node(i, ww));
                }
            }
        }
    }
}

class Node implements Comparable<Node> {

    int n;
    int w;

    public Node(int n, int w) {
        this.n = n;
        this.w = w;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.w, other.w);
    }
}