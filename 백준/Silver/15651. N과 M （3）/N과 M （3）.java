import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int M = input.nextInt();

        backTracking(M, new ArrayList<>(), N);
        System.out.print(sb.toString());
    }

    private static void backTracking(int size, List<Integer> nums, int last) {
        if (size == nums.size()) {
            for (int i : nums) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i < last + 1; i++) {
            nums.add(i);
            backTracking(size, nums, last);
            nums.remove(nums.size() - 1);
        }
    }
}
