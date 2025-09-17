import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    // 설계
    // 12345678 <- 주어진 수
    // 찾고자 하는 수가 2 라면,
    // 1 가져와서 reverse 해서 뒤에 붙이고
    // 2 없애고 원래 2 가 있던 idx 만큼 count 증가
    // -> 3456781

    static List<Integer> given = new ArrayList<>();
    static Queue<Integer> targets = new LinkedList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // setting
        int N = input.nextInt();
        int M = input.nextInt();

        for (int i = 0; i < N; i++) {
            given.add(i + 1);
        }

        for (int i = 0; i < M; i++) {
            targets.add(input.nextInt());
        }

        // do
        int count = 0;

        while (!targets.isEmpty()) {
            int idx = findIdx(targets.poll());


            if (idx == 0) {
                given.remove(0);
            } else if (idx <= given.size() / 2) {
                leftMove(idx);
                count += idx;
                given.remove(0);
            } else {
                rightMove(given.size() - idx);
                count += given.size() - idx;
                given.remove(0);
            }
        }

        System.out.println(count);
    }

    private static void rightMove(int idx) {
        for (int i = 0; i < idx; i++) {
            int right = given.get(given.size() - 1);
            given.remove(given.size() - 1);
            given.add(0, right);
        }
    }

    private static void leftMove(int idx) {
        for (int i = 0; i < idx; i++) {
            int left = given.get(0);
            given.remove(0);
            given.add(left);
        }
    }

    private static int findIdx(int target) {
        for (int i = 0; i < given.size(); i++) {
            if (given.get(i) == target) {
                return i;
            }
        }

        return -1;
    }
}
