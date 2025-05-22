import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Solution {
    
    public static int[] solution(String s) {
        String[] splitStringNumbers = splitStringNumbers(s);
        Arrays.sort(splitStringNumbers, Comparator.comparingInt(String::length));
        int[] answer = new int[splitStringNumbers.length];

        Set<Integer> duplicatedNumber = new HashSet<>();
        for (int i = 0; i < splitStringNumbers.length; i++) {
            String[] splitCommaNumber = splitStringNumbers[i].split(",");
            for (String number : splitCommaNumber) {
                if(Objects.equals(number, "")) {
                    continue;
                }
                int num = Integer.parseInt(number);
                if(!duplicatedNumber.contains(num)) {
                    answer[i] = num;
                    duplicatedNumber.add(num);
                }
            }
        }

        return answer;
    }

    private static String[] splitStringNumbers(String s) {
        return s.substring(0, s.length() - 2)
                .replaceAll("[{]", "")
                .split("}");
    }
}
