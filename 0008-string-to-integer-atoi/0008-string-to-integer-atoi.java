class Solution {
    private long solve(String s, int i, long num) {
        if (i == s.length() || !Character.isDigit(s.charAt(i))) return num;

        if (num > (Long.MAX_VALUE - s.charAt(i) - '0') / 10) {
            return Long.MAX_VALUE;
        }

        num = num * 10 + (s.charAt(i) - '0');
        return solve(s, i + 1, num);
    }

    public int myAtoi(String s) {
        int i = 0;

        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        boolean sign = true;
        if (i < s.length() && s.charAt(i) == '-') {
            sign = false;
            i++;
        } else if (i < s.length() && s.charAt(i) == '+') {
            i++;
        }

        long num = solve(s, i, 0);
        if (sign && num > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (!sign && -num < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        
        return (int) (sign ? num : -num);
    }
}