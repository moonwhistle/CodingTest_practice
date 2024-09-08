import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public String[] solution(String my_string) {
        String[] answer = new String[my_string.length()];
        List<String> stringList = new ArrayList<>();
        for (int i = my_string.length() - 1; i >= 0; i--) {
            stringList.add(my_string.substring(i));
        }
        Collections.sort(stringList);
        int count = 0;
        for (String string : stringList) {
            answer[count] = string;
            count++;
        }
        return answer;
    }
}