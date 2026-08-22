class Solution {
    public boolean checkDivisibility(int n) {
        long sum = 0;
        long prod = 1;
        int temp = n;

        while (temp != 0) {
            int lastDigit = temp % 10;
            sum += lastDigit;
            prod *= lastDigit;
            temp /= 10;
        }

        return n % (sum + prod) == 0 ? true : false;
    }
}