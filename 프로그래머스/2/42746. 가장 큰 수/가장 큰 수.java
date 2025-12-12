import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        List<Num> nums = new ArrayList<>();

        for (int number : numbers) {
            nums.add(new Num(String.valueOf(number)));
        }

        Collections.sort(nums);

        for (int i = 0; i < nums.size(); i++) {
            String num = nums.get(i).num;

            if (i == 0 && num.equals("0")) {
                return num;
            }

            answer += num;
        }

        return answer;
    }
}

class Num implements Comparable<Num> {

    String num;

    public Num(String num) {
        this.num = num;
    }

    @Override
    public int compareTo(Num o) {
        return (o.num + this.num).compareTo(this.num + o.num);
    }
}
