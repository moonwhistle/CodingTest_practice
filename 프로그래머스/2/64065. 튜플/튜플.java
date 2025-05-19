import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Solution {

    public static int[] solution(String s) {
        String[] splitNumber = splitNumbers(s);
        int[] answer = new int[splitNumber.length];
        Set<String> exist = new HashSet<>();

        for (int i = 0; i < splitNumber.length; i++) {
            String[] numbers = splitNumber[i].split(",");

            for(String number : numbers) {
                if (Objects.equals(number, "")) {
                    continue;
                }
                if(!exist.contains(number)) {
                    answer[i] = Integer.parseInt(number);
                    exist.add(number);
                }
            }
        }

        return answer;
    }

    private static String[] splitNumbers(String s) {
        String removedOpenBraceString = s.substring(0, s.length() - 2)
                .replaceAll("[{]", "");

        String[] splitString = removedOpenBraceString.split("}");
        Arrays.sort(splitString, Comparator.comparing(String::length));

        return splitString;
    }
}
