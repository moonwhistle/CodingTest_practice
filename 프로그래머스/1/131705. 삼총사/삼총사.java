import java.util.ArrayList;
import java.util.List;

class Solution {

    static boolean[] visited;
    static List<List<Integer>> three = new ArrayList<>();

    public static int solution(int[] number) {
        int answer = 0;
        //세팅
        visited = new boolean[number.length];
        dfs(number, new ArrayList<>(), 0);
        for(List<Integer> threeElement : three) {
            int sum = threeElement.get(0) + threeElement.get(1) + threeElement.get(2);
            if(sum == 0) {
                answer++;
            }
        }
        return answer;
    }

    private static void dfs(int[] number, List<Integer> threeSet, int start) {
        if(threeSet.size() == 3) {
            three.add(threeSet);
            return;
        }

        for(int i = start; i<number.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                threeSet.add(number[i]);
                dfs(number, new ArrayList<>(threeSet), i + 1);
                threeSet.remove(threeSet.size() - 1);
                visited[i] = false;
            }
        }
    }
}
