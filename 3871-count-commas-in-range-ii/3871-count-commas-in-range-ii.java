class Solution {
    public long countCommas(long n) {
        long ans = 0;
        long start = 1000;
        long comma = 1;

        while (start <= n) {
            long end = Math.min(n, start * 1000 - 1);
            long count = end - start + 1;

            ans += count * comma;

            start *= 1000;
            comma++; 
        }

        return ans;
    }
}