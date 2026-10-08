class Solution {
    public long maxArrayValue(int[] nums) {
        if (nums.length == 1) return nums[0];
        
        long ans = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > ans) ans = nums[i];
            else {
                ans = Math.max(ans, ans + nums[i]);
            }
        }

        return ans;
    }
}