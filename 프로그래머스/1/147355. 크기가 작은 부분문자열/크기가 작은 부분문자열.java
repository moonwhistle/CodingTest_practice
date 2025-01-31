class Solution {

    public static int solution(String t, String p) {
        int answer = 0;
        //세팅
        int length = p.length();
        long pNumber = Long.parseLong(p);
        //로직
        for (int i = 0; i < t.length() - length + 1; i++) {
            String s = t.substring(i, i + length);
            System.out.println(s);
            if (Long.parseLong(s) <= pNumber) {
                answer++;
            }
        }
        return answer;
    }
}
