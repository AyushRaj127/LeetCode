class Solution {
    public int minOperations(int[] nums, int x) {
        int total = 0;

        for (int num : nums) {
            total += num;
        }

        if (total < x) return -1;
        if (total == x) return nums.length;

        int left = 0;
        int sum = 0;
        int count = -1;
        int target = total - x;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum > target && left <= right) {
                sum -= nums[left];
                left++;
            }

            if (sum == target) {
                count = Math.max(count, right - left + 1);
            }
        }

        return count == -1 ? -1 : nums.length - count;
    }
}