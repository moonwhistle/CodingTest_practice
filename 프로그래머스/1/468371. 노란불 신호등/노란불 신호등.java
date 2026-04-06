class Solution {
    
    static int[] point;
    static int[] sum;
    static int end;
    
    public static int solution(int[][] signals) {
        int answer = -1;
        point = new int[signals.length];
        sum = new int[signals.length];
        makeSum(signals);
        getEnd();
        int idx = 1;
        
        while(idx <= end) {
            for(int i = 0 ; i < signals.length; i++) {
                int s = sum[i];
                int[] signal = signals[i];
                int index = (idx - 1) % s + 1;
                int count = -1;
                
                while(index > 0) {
                    count++;
                    index -= signal[count];
                }
                
                if(count == 1) {
                    point[i] = count;
                } else {
                    point[i] = 0;
                }
            }
            
            if(isYellow()) {
                answer = idx;
                break;
            }
            
            idx++;
        }
        
        return answer;
    }
    
    private static boolean isYellow() {
        for(int i : point) {
            if(i != 1) {
                return false;
            }
        }
        
        return true;
    }
    
    private static void getEnd() {
        end = sum[0];
        
        for(int i = 1; i < sum.length; i++) {
            end = lcm(end, sum[i]);
        }
    }
    
    private static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
    
    private static void makeSum(int[][] signals) {
        for(int i = 0 ; i < signals.length; i++) {
            int s = 0;
            
            for(int signal : signals[i]) {
                s += signal;
            }
            
            sum[i] = s; 
        }
    }

    private static int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        
        return gcd(b, a % b);
    }
}