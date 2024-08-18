class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        char[] xx = Integer.toString(x).toCharArray();
        int index = xx.length - 1;
        for (int i = 0; i < xx.length; i++) {
            if (xx[i] != xx[index - i]) {
                return false;
            }
        }
        return true;
    }
}