import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        List<Character> skipBox = makeSkipBox(skip);

        for (char c : s.toCharArray()) {
            answer.append(changeWord(c, skipBox, index));
        }

        return answer.toString();
    }

    public static List<Character> makeSkipBox(String skip) {
        List<Character> skipBox = new ArrayList<>();

        for (Character c : skip.toCharArray()) {
            skipBox.add(c);
        }

        return skipBox;
    }

    public static String changeWord(char c, List<Character> skipBox, int index) {
        int count = 0;
        char now = c;

        while (count < index) {
            now ++;

            if(now > 'z') {
                now = 'a';
            }
            if(!skipBox.contains(now)) {
                count++;
            }
        }

        return String.valueOf(now);
    }
}
