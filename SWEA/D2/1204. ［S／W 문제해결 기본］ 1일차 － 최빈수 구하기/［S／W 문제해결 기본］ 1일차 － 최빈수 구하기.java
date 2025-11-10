import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();

        for (int i = 1; i <= T; i++) {
            int test = input.nextInt();
            Map<Integer, Number> counts = new HashMap<>();

            for (int j = 0; j < 1000; j++) {
                int num = input.nextInt();
                counts.putIfAbsent(num, new Number(num));
                Number number = counts.get(num);
                number.add();
            }

            List<Number> numbers = new ArrayList<>(counts.values());
            Collections.sort(numbers);

            System.out.println("#" + test + " " + numbers.get(0).num());
        }
    }
}

class Number implements Comparable<Number> {

    private final int num;
    private int count;

    Number(int num) {
        this.num = num;
        this.count = 0;
    }

    @Override
    public int compareTo(Number o) {
        if (count == o.count) {
            return o.num - this.num;
        }

        return o.count - this.count;
    }

    public void add() {
        this.count++;
    }

    public int num() {
        return num;
    }
}
