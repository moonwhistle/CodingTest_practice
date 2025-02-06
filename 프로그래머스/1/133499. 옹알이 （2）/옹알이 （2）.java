class Solution {

    static String[] possible = new String[]{"aya", "ye", "woo", "ma"};

    public static int solution(String[] babbling) {
        int answer = 0;

        for(String babble : babbling) {
            String s = babble;
            boolean isAnnounce = false;
            for(String possibleElement : possible) {
                if(babble.contains(possibleElement + possibleElement)) {
                    isAnnounce = true;
                    break;
                }
            }
            
            if(isAnnounce) {
                continue;
            }

            for(String possibleElement : possible) {
                s = s.replace(possibleElement, " ");
            }

            if(s.trim().isEmpty() && !isAnnounce) {
                answer++;
            }
        }
        System.out.println(answer);
        return answer;
    }
}
