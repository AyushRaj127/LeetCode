class Solution {
    private int digits(int n) {
        int temp = n;
        int sum = 0;
        
        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }

        return sum;
    }

    public int smallestIndex(int[] nums) {
        int ans = nums.length + 1;

        for (int i = 0; i < nums.length; i++) {
            if (i == digits(nums[i])) {
                ans = Math.min(i, ans);
            }
        }

        return ans == nums.length + 1 ? -1 : ans;
    }
}