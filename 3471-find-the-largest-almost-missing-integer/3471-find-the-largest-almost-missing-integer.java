class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        int[] freq = new int[51];

        for (int num : nums) {
            freq[num]++;
        }

        int res = -1;

        for (int i = 0; i < n; i++) {
            if (k == n || freq[nums[i]] == 1 && (k == 1 || i == 0 || i == n - 1)) {
                res = Math.max(res, nums[i]);
            }
                
        }

        return res;
    }
}