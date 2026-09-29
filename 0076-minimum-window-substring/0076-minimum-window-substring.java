class Solution {
    public String minWindow(String s, String t) {
        int minLength = Integer.MAX_VALUE;
        int start = -1;
        int[] freq = new int[256];

        for (char c : t.toCharArray()) {
            freq[c]++;
        }

        int left = 0;
        int right = 0;
        int count = 0;

        while (right < s.length()) {
            if (freq[s.charAt(right)] > 0) {
                count++;
            }

            freq[s.charAt(right)]--;

            while (count == t.length()) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }

                freq[s.charAt(left)]++;

                if (freq[s.charAt(left)] > 0) count--;

                left++;
            }

            right++;
        }

        return start == -1 ? "" : s.substring(start, start + minLength);
    }
}