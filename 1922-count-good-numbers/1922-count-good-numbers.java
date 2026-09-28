class Solution {
    private static final long MOD = 1000000007;

    private long power(long num, long pow) {
        if (pow == 0) return 1;

        long half = power(num, pow / 2);
        long result = (half * half) % MOD;

        if (pow % 2 == 1) {
            result = (result * num) % MOD;
        }

        return result;
    }

    public int countGoodNumbers(long n) {
        return (int) ((power(5, (n + 1) / 2) * power(4, n / 2)) % MOD);
    }
}