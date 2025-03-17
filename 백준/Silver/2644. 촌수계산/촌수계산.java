import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList[] people;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); //전체 사람 수
        int firstTarget = input.nextInt();
        int secondTarget = input.nextInt();
        int m = input.nextInt(); //부모 자식 관계

        //세팅
        people = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            people[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) { //관계 입력받기
            int first = input.nextInt();
            int second = input.nextInt();
            people[first].add(second);
            people[second].add(first);
        }

        int answer = dfs(firstTarget, secondTarget, 0);

        System.out.println(answer);
    }

    private static int dfs(int start, int target, int depth) {
        if (start == target) {
            return depth;
        }

        visited[start] = true;
        ArrayList<Integer> elements = people[start];

        for (Integer element : elements) {
            if (!visited[element]) {
                int result = dfs(element, target, depth + 1);
                if (result != -1) {
                    return result;
                }
            }
        }

        return -1;
    }
}
