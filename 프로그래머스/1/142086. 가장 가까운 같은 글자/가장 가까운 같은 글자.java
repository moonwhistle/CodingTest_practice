import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<String, Integer> wordInformation = new HashMap<>();
        char[] words = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            String word = String.valueOf(words[i]);
            if (!wordInformation.containsKey(word)) {
                answer[i] = -1;
                wordInformation.put(word, i + 1);
            } else {
                int position = i + 1 - wordInformation.get(word);
                answer[i] = position;
                wordInformation.put(word, i + 1);
            }
        }

        return answer;
    }
}
