import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    static Map<String, Integer> numbers = new HashMap<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        makeNumbers();

        int T = input.nextInt();

        for (int i = 0; i < T; i++) {
            List<Number> nums = new ArrayList<>();
            String testCase = input.next();
            int count = input.nextInt();

            for (int j = 0; j < count; j++) {
                String num = input.next();
                nums.add(new Number(num, numbers.get(num)));
            }

            Collections.sort(nums);

            System.out.println(testCase);
            for (Number number : nums) {
                System.out.print(number.number() + " ");
            }
            System.out.println();
        }
    }

    private static void makeNumbers() {
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

class Number implements Comparable<Number> {

    private final String number;
    private final int weight;

    public Number(String number, int weight) {
        this.number = number;
        this.weight = weight;
    }

    @Override
    public int compareTo(Number other) {
        return this.weight - other.weight;
    }

    public String number() {
        return number;
    }
}

