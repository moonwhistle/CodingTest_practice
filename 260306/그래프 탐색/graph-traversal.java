import java.util.*;

public class Main {

    static int n;
    static int m;
    static boolean[] visited;
    static int count;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        visited = new boolean[n + 1];
        count = 0;
        list = new ArrayList[n + 1];

        for(int i = 1 ; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            list[s].add(e);
            list[e].add(s);
        }
        // Please write your code here.
        dfs(1);

        System.out.println(count - 1);
    }

    private static void dfs(int idx) {
        if(visited[idx]) {
            return;
        }

        visited[idx] = true;
        count++;

        for(int e : list[idx]) {
            dfs(e);
        }
    }
}