class Solution {
    public int solution(long num) {
        return makeFistNumber(num, 0);
    }

    private int makeFistNumber(long num, int count) {
        if(count > 500) {
            return -1;
        }

        if(num == 1) {
            return count;
        }

        if(num % 2 == 0) {
            return makeFistNumber(num / 2, count + 1);
        } else {
            return makeFistNumber(num * 3 + 1, count + 1);
        }
    }
}
