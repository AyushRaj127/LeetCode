class Solution {
    public int reverseDegree(String s) {
        int degree = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int ind = i + 1;
            int st = c - 'a' + 1;
            int rev = 27 - st;
            
            degree += rev * ind;
        }
        return degree;
    }
}