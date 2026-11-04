class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int left = 0;
        int right = 0;
        int count = 0;

        Arrays.sort(g);
        Arrays.sort(s);

        while (left < g.length && right < s.length) {
            if (g[left] <= s[right]) {
                count++;
                left++;
            }

            right++;
        }

        return count;
    }
}