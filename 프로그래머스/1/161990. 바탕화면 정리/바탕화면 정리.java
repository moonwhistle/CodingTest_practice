class Solution {
    
    static int minX = Integer.MAX_VALUE;
    static int minY = Integer.MAX_VALUE;
    static int maxX = Integer.MIN_VALUE;
    static int maxY = Integer.MIN_VALUE;
    
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[0].length(); j++) {
                if(wallpaper[i].charAt(j) == '#') {
                    minY = Math.min(minY, i);
                    minX = Math.min(minX, j);
                    maxX = Math.max(maxX, j);
                    maxY = Math.max(maxY, i);
                }
            }
        }
        
        answer[0] = minY;
        answer[1] = minX;
        answer[2] = maxY + 1;
        answer[3] = maxX + 1;

        return answer;
    }
}