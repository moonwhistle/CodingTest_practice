import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();

        // setting
        int sum = 0;
        Map<Integer, Integer> count = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int[] array = new int[N];
        int idx = 0;

        // input
        for(int i = 0 ; i<N;i ++) {
            int num = input.nextInt();

            // sum
            sum += num;

            // count
            count.put(num, count.getOrDefault(num, 0) + 1);

            // max
            max = Math.max(max, num);

            // min
            min = Math.min(min, num);

            // array
            array[idx] = num;
            idx++;
        }
        Arrays.sort(array);

        // avg
        int avg = Math.round((float) sum / N);
        System.out.println(avg);

        // mid
        int midCount = 0;
        int maxCount = Integer.MIN_VALUE;
        for(int i : count.values()) {
            midCount += i;
            maxCount = Math.max(maxCount, i);
        }
        midCount /=2;
        System.out.println(array[midCount]);

        // frequently
        List<Integer> frequentNum = new ArrayList<>();
        for(int num : count.keySet()) {
            if(count.get(num) == maxCount) {
                frequentNum.add(num);
            }
        }
        Collections.sort(frequentNum);
        if(frequentNum.size() > 1) {
            System.out.println(frequentNum.get(1));
        } else {
            System.out.println(frequentNum.get(0));
        }

        // range
        System.out.println(max - min);
    }
}

