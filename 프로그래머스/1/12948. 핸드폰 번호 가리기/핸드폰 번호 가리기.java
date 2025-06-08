class Solution {

    public static String solution(String phone_number) {
        String answer = "";
        int size = phone_number.length();
        String start = phone_number.substring(0, size - 4)
                .replaceAll("[0-9]", "*");

        String end = phone_number.substring(size-4);

        answer += start + end;
        return answer;
    }
}
