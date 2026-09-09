class Solution {
    private void generate(int[] nums, int i, List<Integer> current, List<List<Integer>> result) {
        if (i == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[i]);
        generate(nums, i + 1, current, result);

        current.remove(current.size() - 1);
        generate(nums, i + 1, current, result);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        generate(nums, 0, current, result);
        return result;
    }
}