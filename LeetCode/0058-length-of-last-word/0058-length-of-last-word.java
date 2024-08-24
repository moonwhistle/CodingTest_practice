class Solution {
    public int lengthOfLastWord(String s) {
        String[] sss = s.trim().replaceAll(" ", ",").split(",");
        return sss[sss.length-1].length();
    }
}