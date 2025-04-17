import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static int[] prize;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();
        prize = new int[T];

        Map<Integer, Integer> firstContestInformation = firstContest();
        Map<Integer, Integer> secondContestInformation = secondContest();

        for(int i = 0; i<T; i++) {
            int first = input.nextInt();
            int second = input.nextInt();
            getPrize(firstContestInformation, first, i);
            getPrize(secondContestInformation, second, i);
        }

        for(int i : prize) {
            System.out.println(i);
        }
    }

    private static void getPrize(Map<Integer, Integer> contestInformation, int grade, int order) {
        if(grade != 0) {
            int sum = 0;

            for(int i : contestInformation.keySet()) {
                sum += i;
                if(sum >= grade) {
                    prize[order] += contestInformation.get(i);
                    break;
                }
            }
        }
    }

    private static Map<Integer, Integer> firstContest() {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        map.put(1, 5000000);
        map.put(2, 3000000);
        map.put(3, 2000000);
        map.put(4, 500000);
        map.put(5, 300000);
        map.put(6, 100000);
        return map;
    }

    private static Map<Integer, Integer> secondContest() {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        map.put(1, 5120000);
        map.put(2, 2560000);
        map.put(4, 1280000);
        map.put(8, 640000);
        map.put(16, 320000);
        return map;
    }
}
