import java.util.HashMap;
import java.util.Map;

class Solution {

    static int[] w = {781, 156, 31, 6, 1};
    static Map<Character, Integer> words = new HashMap<>();

    public int solution(String word) {
        int answer = 0;
        makeMap();

        int idx = 0;
        for (char wordElement : word.toCharArray()) {
            answer += (w[idx] * words.get(wordElement)) + 1;
            idx++;
        }

        return answer;
    }

    private static void makeMap() {
        words.put('A', 0);
        words.put('E', 1);
        words.put('I', 2);
        words.put('O', 3);
        words.put('U', 4);
    }
}
