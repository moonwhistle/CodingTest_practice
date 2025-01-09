import java.util.Scanner;

public class Main {

    static int[] box;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int m = input.nextInt();

        box = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            box[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int check = input.nextInt();
            int a = input.nextInt();
            int b = input.nextInt();

            if (check == 0) {
                union(a, b);
            } else if (check == 1) {
                if (find(a) == find(b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    public static void union(int a, int b) {
        int x = find(a);
        int y = find(b);

        if (x != y) {
            box[y] = x;
        }
    }

    public static int find(int x) {
        if (box[x] != x) {
            box[x] = find(box[x]);
        }
        return box[x];
    }
}
