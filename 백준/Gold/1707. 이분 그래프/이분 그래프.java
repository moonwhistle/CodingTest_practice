import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Integer>[] list;
    static boolean isEven;
    static boolean[] visited;
    static int[] color;


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int K = input.nextInt();

        for (int i = 0; i < K; i++) {
            int V = input.nextInt();
            int E = input.nextInt();

            list = new ArrayList[V + 1];
            color = new int[V+1];
            visited = new boolean[V+1];
            isEven = true;

            //리스트 초기화
            for (int k = 0; k < V + 1; k++) {
                list[k] = new ArrayList<>();
            }

            //배열 만들기
            for (int k = 0; k < E; k++) {
                int start = input.nextInt();
                int last = input.nextInt();

                list[start].add(last);
                list[last].add(start);
            }

            //DFS
            for(int k = 1; k<=V; k++) {
                if(isEven) {
                    DFS(k);
                } else {
                    break;
                }
            }

            //
            if(isEven) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static void DFS(int start) {
        visited[start] = true;
        for (int num : list[start]) {
            if (!visited[num]) {
                color[num] = (color[start] + 1) % 2;
                DFS(num);

            } else if(color[start] == color[num]){
                isEven = false;
            }
        }
    }
}
