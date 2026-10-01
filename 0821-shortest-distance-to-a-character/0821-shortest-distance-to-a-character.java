class Solution {
    public int[] shortestToChar(String s, char c) {
        int[] ans = new int[s.length()];
        int prev = s.indexOf(c);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                prev = i;
            }

            ans[i] = Math.abs(i - prev);
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                prev = i;
            }

            ans[i] = Math.min(ans[i], Math.abs(i - prev));
        }
        
        return ans;
    }
}