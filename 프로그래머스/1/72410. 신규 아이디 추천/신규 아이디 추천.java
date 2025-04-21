public class Solution {

    private static final String SPECIAL_STRING_REGEX = "[^a-z0-9._-]";
    private static final String CONTINUOUS_SPOT = "[.]{2,}";
    private static final String SPOT = ".";
    private static final String FIRST_LAST_SPOT = "^\\.|\\.$";

    public static String solution(String new_id) {
        String answer = "";
        String replaceSpecialRegex = new_id.toLowerCase().replaceAll(SPECIAL_STRING_REGEX, "");
        String replaceSpot = replaceSpecialRegex.replaceAll(CONTINUOUS_SPOT, SPOT);
        String checkSpot = checkFirstLastSpot(replaceSpot);
        String checkEmptyString = checkEmptyString(checkSpot);
        String checkLength = checkLength(checkEmptyString);
        String checkSpotAgain = checkFirstLastSpot(checkLength);
        answer = increaseString(checkSpotAgain);
        System.out.println(answer);
        return answer;
    }

    private static String checkFirstLastSpot(String given) {
        return given.replaceAll(FIRST_LAST_SPOT, "");
    }

    private static String checkEmptyString(String given) {
        if (given.isEmpty()) {
            return "a";
        }

        return given;
    }

    private static String checkLength(String given) {
        if (given.length() >= 16) {
            return given.substring(0, 15);
        }

        return given;
    }

    private static String increaseString(String given) {
        if (given.length() < 3) {
            StringBuilder newString = new StringBuilder(given);
            while (newString.length() < 3) {
                newString.append(newString.charAt(newString.length() - 1));
            }

            return newString.toString();
        }

        return given;
    }
}
