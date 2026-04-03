class Solution {
    
    static int MOD = 1000000007;
    static int[][] map;
    
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        map = new int[n][m];
        
        for(int[] puddle : puddles) {
            int y = puddle[1] - 1;
            int x = puddle[0] - 1;
            map[y][x] = -1;
        }
        
        for(int y = 0 ; y < n ; y++) {
            if(map[y][0] == -1) {
                break;
            }
            
            map[y][0] = 1;
        }
        
        for(int x = 0 ; x < m ; x++) {
            if(map[0][x] == -1) {
                break;
            }
            
            map[0][x] = 1;
        }
        
        for(int y = 1 ; y < n ; y ++) {
            for(int x = 1 ; x < m; x++) {
                if(map[y][x] == -1) {
                    continue;
                }
                
                int up = map[y-1][x];
                int back = map[y][x -1];
                
                if(up == -1 && back == -1) {
                    continue;
                } else if(up == -1) {
                    map[y][x] = back;
                } else if(back == -1) {
                    map[y][x] = up;
                } else {
                    map[y][x] = (up + back) % MOD;
                }
            }
        }
        
        answer = map[n-1][m-1];
        return answer;
    }
}