class Solution {
    private void subsets(int[] nums, int i, List<Integer> current, List<List<Integer>> result, Set<List<Integer>> seen) {
        if (i == nums.length) {
            if (!seen.contains(current)) {
                seen.add(new ArrayList<>(current));
                result.add(new ArrayList<>(current));
            }
            return;
        }

        current.add(nums[i]);
        subsets(nums, i + 1, current, result, seen);

        current.remove(current.size() - 1);
        subsets(nums, i + 1, current, result, seen);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        Set<List<Integer>> seen = new HashSet<>();
        
        Arrays.sort(nums);

        subsets(nums, 0, current, result, seen);
        return result;
    }
}