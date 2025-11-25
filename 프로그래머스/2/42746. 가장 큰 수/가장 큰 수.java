import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

class Solution {

    public static String solution(int[] numbers) {
        String answer = "";
        List<Num> nums = new ArrayList<>();

        for (int number : numbers) {
            nums.add(new Num(String.valueOf(number)));
        }

        Collections.sort(nums);

        if (Objects.equals(nums.get(0).number, "0")) {
            return "0";
        }

        for (Num num : nums) {
            answer += num.number;
        }

        return answer;
    }
}

class Num implements Comparable<Num> {

    String number;

    public Num(String number) {
        this.number = number;
    }

    @Override
    public int compareTo(Num other) {
        return (other.number + this.number).compareTo(this.number + other.number);
    }
}
