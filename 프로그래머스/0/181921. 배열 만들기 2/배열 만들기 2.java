import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public static int[] solution(int l, int r) {
        List<Integer> box = new ArrayList<>();

        dfs("5", r, box);

        box.removeIf(num -> num <l);

        if(box.isEmpty()) {
            return new int[]{-1};
        }
        
        Collections.sort(box);

        return box.stream()
                .mapToInt(Integer::intValue)
                .toArray();

    }

    public static void dfs(String i, int r, List<Integer> answer) {
        int num = Integer.parseInt(i);

        if (num > r) {
            return;
        }

        answer.add(num);

        dfs(i + "5", r, answer);
        dfs(i + "0", r, answer);
    }
}