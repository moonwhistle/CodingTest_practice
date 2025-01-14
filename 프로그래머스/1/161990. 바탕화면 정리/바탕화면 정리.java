public class Solution {

    public static int[] solution(String[] wallpaper) {
        int[] answer = new int[4];

        //세팅
        int startX = Integer.MAX_VALUE;
        int startY = Integer.MAX_VALUE;
        int lastX = Integer.MIN_VALUE;
        int lastY = Integer.MIN_VALUE;

        // '#' 인덱스를 뽑아내며 위치 비교하기
        for(int i = 0; i< wallpaper.length; i++) {
            for(int k = 0; k<wallpaper[i].length(); k++) {
                if(wallpaper[i].charAt(k) == '#') {
                    startX = Math.min(startX, i);
                    startY = Math.min(startY, k);
                    lastX = Math.max(lastX, i);
                    lastY = Math.max(lastY, k);
                }
            }
        }

        answer[0] = startX;
        answer[1] = startY;
        answer[2] = lastX + 1;
        answer[3] = lastY + 1;

        return answer;
    }
}
