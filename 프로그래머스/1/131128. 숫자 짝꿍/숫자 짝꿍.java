import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

class Solution {

    public static String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        //같은 숫자가 몇 개가 있는지 뽑아낸다
        //먼저 X가 어떤 숫자를 몇 개 가지고 있는지 세팅한다
        Map<String, Integer> xElement = new TreeMap<>(Comparator.reverseOrder());
        for (char x : X.toCharArray()) {
            String key = String.valueOf(x);
            xElement.put(key, xElement.getOrDefault(key, 0) + 1);
        }
        //세팅한 xElement 를 토대로 Y의 문자열과 겹치는 숫자를 판별한다.
        for (String key : xElement.keySet()) {
            int xCount = xElement.get(key);
            int yCount = 0;
            for (char y : Y.toCharArray()) {
                if (String.valueOf(y).equals(key)) {
                    yCount++;
                }
            }
            if (yCount == 0) {
                continue;
            }
            int min = Math.min(xCount, yCount);
            answer.append(key.repeat(min));
        }

        if (answer.length() == 0) {
            return "-1";
        }

        if (answer.toString().matches("^0+$")) {
            return "0";
        }

        return answer.toString();
    }
}
