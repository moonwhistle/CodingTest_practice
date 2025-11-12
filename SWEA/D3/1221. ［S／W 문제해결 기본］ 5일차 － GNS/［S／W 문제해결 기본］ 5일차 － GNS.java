import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    static Map<String, Integer> numbers = new HashMap<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();
        makeMap();

        for (int i = 0; i < T; i++) {
            String testCase = input.next();
            int N = input.nextInt();
            List<Num> nums = new ArrayList<>();

            for (int j = 0; j < N; j++) {
                String str = input.next();
                nums.add(new Num(str, numbers.get(str)));
            }

            Collections.sort(nums);

            System.out.println(testCase);
            for (Num num : nums) {
                System.out.print(num.str() + " ");
            }
            System.out.println();
        }
    }

    private static void makeMap() {
        numbers.put("ZRO", 0);
        numbers.put("ONE", 1);
        numbers.put("TWO", 2);
        numbers.put("THR", 3);
        numbers.put("FOR", 4);
        numbers.put("FIV", 5);
        numbers.put("SIX", 6);
        numbers.put("SVN", 7);
        numbers.put("EGT", 8);
        numbers.put("NIN", 9);
    }
}

class Num implements Comparable<Num> {

    private final String str;
    private final int value;

    Num(String str, int value) {
        this.str = str;
        this.value = value;
    }

    @Override
    public int compareTo(Num o) {
        return this.value - o.value;
    }

    public String str() {
        return str;
    }
}

