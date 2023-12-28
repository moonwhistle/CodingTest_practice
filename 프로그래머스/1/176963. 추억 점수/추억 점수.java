import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> dic = new HashMap<String, Integer>();
        int n = photo.length;
        int[] answer = new int[n];
        for(int i=0;i< name.length;i++)
        {
            dic.put(name[i],yearning[i]);
        }
        int i=0;

        for(String[] row: photo)
        {
            int score = 0;

            for(String key: row)
            {
                if(dic.containsKey(key))
                {
                    score += dic.get(key);
                }
                else
                {
                    ;
                }
            }
            answer[i] = score;
            i++;
        }

        return answer;
    }
}