import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int M = input.nextInt();

        backTracking(M, new ArrayList<>(), 1, N);
    }

    private static void backTracking(int size, List<Integer> nums, int start, int last) {
        if(size == nums.size()) {
            for(int i : nums) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for(int i = start; i<last + 1; i++) {
            if(nums.contains(i)) {
                continue;
            }
            nums.add(i);
            backTracking(size, nums, i + 1, last);
            nums.remove(nums.size() - 1);
        }
    }
}
