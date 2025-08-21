import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

class Solution {

    // input 배열 정렬 후, 리스트 값에 넣으며 비교

    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);

        for(int i = 0; i<phone_book.length -1; i++) {
            String first = phone_book[i];
            String next = phone_book[i+1];
            if(next.startsWith(first)) {
                return false;
            }
        }
        
        return answer;
    }
}
