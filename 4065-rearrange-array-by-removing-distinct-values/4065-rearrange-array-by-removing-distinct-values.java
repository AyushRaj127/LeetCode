class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] count = new int[101];

        for (int num : nums) {
            count[num]++;
        }

        int[] ans = new int[nums.length];
        int index = 0;

        while (index < nums.length) {
            for (int num = 1; num <= 100; num++) {
                if (count[num] > 0) {
                    ans[index] = num;
                    index++;
                    count[num]--;
                }
            }
        }

        return ans;
    }
}
