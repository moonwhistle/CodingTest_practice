import java.util.HashSet;
import java.util.Set;

class Solution {

    static Set<Integer> numberBox;
    static boolean[] visited;

    public static int solution(String numbers) {
        int answer = 0;
        numberBox = new HashSet<>();
        visited = new boolean[numbers.length()];

        dfs(numbers, "0");

        for(int number : numberBox) {
            if(isPrime(number)) {
                answer++;
            }
        }
        
        return answer;
    }

    public static void dfs(String numbers, String current) {
        numberBox.add(Integer.parseInt(current));

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(numbers, current + numbers.charAt(i));
                visited[i] = false;
            }
        }
    }

    public static boolean isPrime(int number) {
        int count = 0;
        if (number == 0 || number == 1) {
            count++;
        }

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                count++;
            }
        }

        return count == 0;
    }
}
