class Solution {
    private void combinations(int k, int n, int count, int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        if (count > k) {
            return;
        }

        if (count == k && n == 0) {
            result.add(new ArrayList(current));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;
            if (nums[i] > n) break;

            current.add(nums[i]);
            combinations(k, n - nums[i], count + 1, i + 1, nums, current, result);
            current.remove(current.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        combinations(k, n, 0, 0, nums, current, result);
        return result;
    }
}